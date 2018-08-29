package org.logan.lambda.chapter4;

import java.util.Optional;

/**
 * desc: java8 Optional 演示 <br/>
 * Optional 是为核心类库新设计的一个数据类型，用来替换 null 值。 <br/>
 * 在调用其get()之前，一定要先调用isPresent()，判断值是否存在，否则会异常。
 * time: 2018/8/8 下午3:28 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C4_22_Optional {

	public static void main(String[] args) {
		/* 1，创建Optional方式 */
		// 创建有值的 Optional 对象，值必须不能为null，否则异常
		Optional<String> a = Optional.of("a");// null -> Java.lang.NullPointerException

		// 创建可null的 Optional 对象，值可以为null
		Optional alsoEmpty = Optional.ofNullable(null);

		// 创建一个空的 Optional 对象
		Optional empty = Optional.empty();


		/* 2，测试Optional get() */
		System.out.println("a.get(): " + a.get());
		// System.out.println("empty.get():" + empty.get()); // -> java.util.NoSuchElementException


		/* 3，测试Optional isPresent() */
		if (empty.isPresent()) {// isPresent(): Optional真实值非null为true
			System.out.println("empty.get() -> " + empty.get());
		} else {
			System.out.println("empty不存在值!");
		}

		// 简洁写法
		empty.ifPresent(value -> // ifPresent：如果Optional实例有值，则执行下面函数，否则不做处理
				System.out.println("testOptional() ->ifPresent() value:" + value)
		);

		/* 4，测试Optional orElse() */
		// orElse：如果Optional有值则将其返回，否则返回指定的其它值，即：orElse()参数指定的值b
		System.out.println("alsoEmpty.orElse(): " + alsoEmpty.orElse("b"));
	}


}
