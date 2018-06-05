package org.logan.lambda.test;

import java.util.function.BinaryOperator;

/**
 * desc: Lambda课程 -- 简单例子 <br/>
 * time: 2018/4/18 下午7:04 <br/>
 * author: 居廉 <br/>
 * since V 1.0 <br/>
 */
class Test1_SimpleDemo {

	public static void main(String[] args) {
		testHelloLambda();
		testTypeInfer();
	}

	// 第一个Lambda表达式
	private static void testHelloLambda() {
		int x = 3;
		new Thread(() -> {
			System.out.println("Hello Lambda！");
		}).start();
	}

	// Lambda 类型推到
	private static void testTypeInfer() {
		// 在Lambda表达式中无需指定类型，程序依然可以编译。这是因为javac根据程序的上下文在后台推断出了参数的类型。
		BinaryOperator<Long> add1 = (x, y) -> x + y;

		// 为了便于阅读，可以指定对应的参数类型
		BinaryOperator<Long> add2 = (Long x, Long y) -> x + y;

		System.out.println("testTypeInfer() -> " + add1.apply(2L, add2.apply(3L, 5L)));
	}


	// Lambda用在哪里。
	// 每一个Lambda都能通过一个特定的"函数接口"与一个给定的类型进行匹配。
	// 因此一个Lambda表达式能被应用在与其目标类型匹配的任何地方，Lambda表达式必须和函数接口的抽象函数描述一样的参数类型，
	// 它的返回类型也必须和抽象函数的返回类型兼容，并且他能抛出的异常也仅限于在函数的描述范围中。
	// Java重要的函数接口：Predicate、Consumer、Function、Supplier、UnaryOperator、BinaryOperator。

}
