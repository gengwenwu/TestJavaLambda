package org.logan.lambda.test.reflect;

/**
 * desc: TODO <br/>
 * time: 2019/5/30 上午10:55 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TypeDemo2 {

	public static void main(String[] args) {
		// ParameterizedType
		try {
			Field f = EntityType3.class.getDeclaredField("a");
			Type t = f.getGenericType();
			UtilForTest.DisplayStr("getClass--:" + t.getClass());
			UtilForTest.DisplayStr("getOwnerType--:" + ((ParameterizedType) t).getOwnerType());  // 获得拥有者   Map<String,Person> map 这个 ParameterizedType 的 getOwnerType() 为 null，而 Map.Entry<String, String> entry 的 getOwnerType() 为 Map 的 Type。
			UtilForTest.DisplayStr("getRawType--:" + ((ParameterizedType) t).getRawType()); // 如 Map<String,Person> map 这个 ParameterizedType 返回的是 Map 类的全限定类名的 Type。  getRawType--:interface java.util.Map
			UtilForTest.DisplayStr("(Class)getRawType--:" + (Class) (((ParameterizedType) t).getRawType())); // Type是强转为Class是否会报错   不会
			UtilForTest.DisplayStr("(Class)getRawType.isAssignableFrom--:" + Collection.class.isAssignableFrom((Class) (((ParameterizedType) t).getRawType()))); // Type强转为Class是否能判断继承关系
//			try {
//				List list1 = (ArrayList) ((Class) (((ParameterizedType) t).getRawType())).newInstance();  // Type强转为Class是否能创建实例,这里是因为List是一个接口，所以并不能直接newInstance
//				UtilForTest.DisplayStr("(List) ((Class)(((ParameterizedType)t).getRawType())).newInstance().size--:" + ((List) ((Class) (((ParameterizedType) t).getRawType())).newInstance()).size()); //
//			} catch (InstantiationException e) {
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				e.printStackTrace();
//			}
			UtilForTest.DisplayStr("getActualTypeArguments()[0]--:" + ((ParameterizedType) t).getActualTypeArguments()[0]);// Type[] getActualTypeArguments(); 返回 这个 Type 类型的参数的实际类型数组。 如 Map<String,Person> map 这个 ParameterizedType 返回的是 String 类,Person 类的全限定类名的 Type Array。
			Type t2 = ((ParameterizedType) t).getActualTypeArguments()[0];
			UtilForTest.DisplayStr("getActualTypeArguments()[0] instanceof ParameterizedType --:" + String.valueOf(t2 instanceof ParameterizedType));  // ParameterizedType参数的内部参数还为ParameterizedType依然可以正确得出
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		List<String> list = new ArrayList<String>();
		listTest(list);
		list.getClass().isPrimitive();
	}

	// 获得方法的参数类型
	public static void listTest(List<String> lists) {
		Type t = lists.getClass();
		System.out.println("Start listTest");
		UtilForTest.ergodicDisplayArray("List.class.getFields() --:", lists.getClass().getFields());  //
		try {
			Method m = TypeDemo2.class.getMethod("listTest", List.class);
			UtilForTest.DisplayStr("getDeclaringClass --:" + String.valueOf(m.getDeclaringClass()));  // 方法定义所在的类
			UtilForTest.ergodicDisplayArray("getParameterTypes() --:", m.getParameterTypes()); // 方法的各个入参的Class数组
			UtilForTest.DisplayStr("getDefaultValue --:" + String.valueOf(m.getDefaultValue())); // 默认值,涉及到注解，具体是什么不太清楚
			UtilForTest.ergodicDisplayArray("getGenericParameterTypes --:", m.getGenericParameterTypes()); //方法的各个入参的Type数组
			UtilForTest.DisplayStr("getGenericParameterTypes.toString --:" + m.getGenericParameterTypes()[0].toString());  // type to string
			UtilForTest.DisplayStr("getGenericParameterTypesIsParameterizedType --:" + String.valueOf(m.getGenericParameterTypes()[0] instanceof ParameterizedType));  // 入参是ParameterizedType-true
			UtilForTest.DisplayStr("m.getGenericParameterTypes()[0]. --》:" + ((ParameterizedType) m.getGenericParameterTypes()[0]).getActualTypeArguments()[0]); // 见main函数该方法释义

			UtilForTest.ergodicDisplayArray("getTypeParameters --:", m.getTypeParameters());  // TypeVariable 数据    TypeVariable是什么见TypeDemo

			UtilForTest.DisplayStr("toGenericString --:" + String.valueOf(m.toGenericString())); // 方法和入参的全限定名
			UtilForTest.DisplayStr("toString --:" + String.valueOf(m.toString()));  // 入参就不是
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		UtilForTest.DisplayStr("getParameterizedTypeByParamsInstance --:" + String.valueOf(t instanceof ParameterizedType));  // 在方法内部可获得入参Type
	}
}