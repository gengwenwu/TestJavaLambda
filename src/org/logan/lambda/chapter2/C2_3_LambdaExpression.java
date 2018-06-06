package org.logan.lambda.chapter2;

import org.logan.lambda.common.helper.View;

import java.util.function.BinaryOperator;

/**
 * desc: Lambda表达式表现形式。<br/>
 * time: 2018/5/5 上午11:15 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class C2_3_LambdaExpression {

	public static void main(String[] args) {
		testLambdaExpression();
	}

	/**
	 * Lambda表达式几种形式
	 */
	private static void testLambdaExpression() {
		// 方式一，不包含参数，使用空括号()表示没有参数。小括号不可以省略。
		Runnable noArgs = () -> System.out.println("Hello World！");

		// 方式二，Lambda 表达式包含且只包含一个参数,可省略参数的小括号。
		View.OnClickListener clickListener = v -> System.out.println("Button Click！");

		// 方式三，Lambda 表达式也可以表示包含多个参数的方法，需要小括号将参数括起来。
		BinaryOperator<Long> add = (x, y) -> x + y;

		// 方式四，Lambda 表达式的主体不仅可以是一个表达式,而且也可以是一段代码块,使用大括号{}将代码块括起来。
		BinaryOperator<Long> add2 = (x, y) -> {
			System.out.println("Hello BinaryOperator！");
			return x + y;
		};

		// 总结
		// (params) -> expression
		// (params) -> statement
		// (params) -> { statements }
	}

}