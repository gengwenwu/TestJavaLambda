package org.logan.lambda.chapter2;

import java.util.function.BinaryOperator;

/**
 * desc: Lambda 类型推导 <br/>
 * time: 2018/6/5 下午1:32 <br/>
 * author: Logan <br/>
 * since V 1。0 <br/>
 */
class C2_9_TypeInfer {

	public static void main(String[] args) {
		// 在Lambda表达式中无需指定类型，程序依然可以编译。这是因为javac根据程序的上下文在后台推断出了参数的类型。
		BinaryOperator<Long> add1 = (x, y) -> x + y;

		// 为了便于阅读，可以指定对应的参数类型
		BinaryOperator<Long> add2 = (Long x, Long y) -> x + y;

		System.out.println("testTypeInfer() -> " + add1.apply(2L, add2.apply(3L, 5L)));
	}

}
