package org.logan.lambda.chapter2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * desc: Lambda 类型推导 <br/>
 * time: 2018/5/5 下午1:32 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C2_9_TypeInfer {

	public static void main(String[] args) {
		// 菱形操作符，类型推导
		testDiamondTypeInfer();

		// 省略菱形中的参数类型传递参数，该语法目前在Java8上才支持
		useHashMap(new HashMap<>());

		// 测试Lambda类型推导
		testLambdaTypeInfer();
	}

	private static void testDiamondTypeInfer() {
		// Java6之前，菱形操作符参数类型必须存在。
		Map<String, Integer> oldWordCounts = new HashMap<String, Integer>();

		//  Java7中的菱形操作符，它可通过 javac 推断出泛型参数的类型，因此可以省略。
		Map<String, Integer> diamondWordCounts = new HashMap<>();
	}

	private static void useHashMap(Map<String, String> values) {
		// test demo
	}

	/**
	 * 测试Lambda类型推导
	 */
	private static void testLambdaTypeInfer() {
		// 类型推断
		Predicate<Integer> atLeast5 = x -> x > 5;

		// 在Lambda表达式中无需指定类型，程序依然可以编译。这是因为javac根据程序的上下文在后台推断出了参数的类型。
		BinaryOperator<Long> add1 = (x, y) -> x + y;
		// BinaryOperator add1 = (x, y) -> x + y;

		// 为了便于阅读，可以指定对应的参数类型
		BinaryOperator<Long> add2 = (Long x, Long y) -> x + y;
		// BinaryOperator add2_1 = (Long x, Long y) -> x + y;

		System.out.println("testTypeInfer() -> " + add1.apply(2L, add2.apply(3L, 5L)));
	}

}
