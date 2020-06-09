package org.logan.lambda.test.reflect;


import org.logan.lambda.test.reflect.model.ModelA;
import org.logan.lambda.test.reflect.model.RemoteModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * desc: TODO <br/>
 * time: 2019/5/30 上午10:54 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class TypeDemo {

	@SuppressWarnings({"rawtypes", "unused"})
	public static void main(String[] args) throws IllegalAccessException {

		RemoteModel model = new RemoteModel("USD", 1, new ModelA());
		Field[] fields = model.getClass().getDeclaredFields();

		for (Field field : fields) {
			System.out.println("field:" + field.getGenericType().getTypeName());

			field.setAccessible(true);

			Object obj = field.get(model);

			if (obj instanceof ModelA) {
				Field[] fields2 = obj.getClass().getDeclaredFields();

				for (Field field2 : fields2) {
					System.out.println("  =====> field:" + field2.getGenericType().getTypeName());
					Annotation[] annotations = field2.getDeclaredAnnotations();

					for (Annotation anno : annotations) {
						field2.setAccessible(true);
						field2.set(obj, model.getCurrency());
						//System.out.println("anno:" + (anno.annotationType().equals("interface org.logan.lambda.test.reflect.model.Curr")));
					}
				}

//				System.out.println(" ===> field:" + fields2.getGenericType().getTypeName());
			}


			System.out.println("model a currency:" + model.getModelA().getCurrency());


		}

//		// ParameterizedType
//		try {
//			Field f = EntityType.class.getDeclaredField("map");
//			Type t = f.getGenericType();
//			UtilForTest.DisplayStr("getClass--:" + t.getClass());
//			UtilForTest.DisplayStr("getOwnerType--:" + ((ParameterizedType) t).getOwnerType());  // 获得拥有者   Map<String,Person> map 这个 ParameterizedType 的 getOwnerType() 为 null，而 Map.Entry<String, String>entry 的 getOwnerType() 为 Map 所属于的 Type。
//			UtilForTest.DisplayStr("getRawType--:" + ((ParameterizedType) t).getRawType()); // 如 Map<String,Person> map 这个 ParameterizedType 返回的是 Map 类的全限定类名的 Type。  getRawType--:interface java.util.Map
//			UtilForTest.DisplayStr("getActualTypeArguments()[0]--:" + ((ParameterizedType) t).getActualTypeArguments()[0]);// Type[] getActualTypeArguments(); 返回 这个 Type 类型的参数的实际类型数组。 如 Map<String,Person> map 这个 ParameterizedType 返回的是 String 类,Person 类的全限定类名的 Type Array。
//			UtilForTest.DisplayStr("getActualTypeArguments()[1]--:" + ((ParameterizedType) t).getActualTypeArguments()[1]);
//
//			Field f2 = EntityType.class.getDeclaredField("et");
//			Type t2 = f2.getGenericType();
//			UtilForTest.DisplayStr("Type.getClass--:" + t2.getClass());
//
//			EntityType2 instance = new EntityType2<String>();
//			UtilForTest.DisplayStr("EntityType2.getGenericSuperclass.getActualTypeArguments--:" + ((ParameterizedType) instance.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);  //getGenericSuperclass获得父类的Type
//			UtilForTest.ergodicDisplayArray("getDeclaredFields--:", instance.getClass().getDeclaredFields());// 通过EntityType2.getDeclaredField是获得不到EntityType中的map属性的,但是确可以获得私有的属性
//			UtilForTest.ergodicDisplayArray("getFields--:", instance.getClass().getFields());// 通过EntityType2.getField可以获得父类EntityType中的map属性，无法获得私有的属性
//			UtilForTest.DisplayStr("getDeclaredField(\"map\").getGenericType()).getActualTypeArguments()[1]--:" + ((ParameterizedType) instance.getClass().getDeclaredField("map2").getGenericType()).getActualTypeArguments()[1]);
//			System.out.println();
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//
//		// TypeVariable  和 WildcardType的定义是差不多的  如果是确定的如T则是TypeVariable,如果是不确定?即是一个表达式(包括一个单独的?)则是WildcardType
//		try {
//			Field fset2 = EntityType2.class.getDeclaredField("set2");
//			ParameterizedType pt1 = (ParameterizedType) fset2.getGenericType();
//			TypeVariable tv1 = (TypeVariable) pt1.getActualTypeArguments()[0];
//			UtilForTest.ergodicDisplayArray("TypeVariable.getBounds()--:", tv1.getBounds()); //获得上边界的数组
//			UtilForTest.DisplayStr("getGenericDeclaration()--:" + tv1.getGenericDeclaration()); // 返回的是声明这个 Type 所在的类 的 Type
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//
//		// GenericArrayType   数组
//		try {
//			Field farr = EntityType2.class.getDeclaredField("arr");
//			Type type = farr.getGenericType();
//			System.out.println("isGenericArrayType--:" + String.valueOf(type instanceof GenericArrayType));
//			GenericArrayType genericArrayType = (GenericArrayType) type;
//			System.out.println("genericArrayType.getGenericComponentType()--:" + genericArrayType.getGenericComponentType());  // 获得数组元素
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}
//
//		// WildcardType   和 TypeVariable的定义是差不多的  如果是确定的如T则是TypeVariable,如果是不确定?即是一个表达式(包括一个单独的?)则是WildcardType
//		try {
//			Field fset3 = EntityType2.class.getDeclaredField("set3");
//			Type type = ((ParameterizedType) fset3.getGenericType()).getActualTypeArguments()[0];
//			System.out.println("isWildcardType--:" + String.valueOf(type instanceof WildcardType));
//			WildcardType wildcardType = (WildcardType) type;
//			System.out.println(wildcardType.getUpperBounds()[0]); // 上界数组
//			Field fset4 = EntityType2.class.getDeclaredField("set4");
//			Type type2 = ((ParameterizedType) fset4.getGenericType()).getActualTypeArguments()[0];
//			System.out.println("isWildcardType--:" + String.valueOf(type2 instanceof WildcardType));
//			WildcardType wildcardType2 = (WildcardType) type2;
//			System.out.println(wildcardType2.getUpperBounds()[0]);
//		} catch (NoSuchFieldException e) {
//			e.printStackTrace();
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		}

	}

}


