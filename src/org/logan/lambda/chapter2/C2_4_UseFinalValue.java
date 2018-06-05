package org.logan.lambda.chapter2;

import org.logan.lambda.common.helper.Button;
import org.logan.lambda.common.helper.View;

import java.util.function.BinaryOperator;

/**
 * desc: Lambda限制，引用的是值，而不是变量 <br/>
 * time: 2018/5/5 上午11:24 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C2_4_UseFinalValue {

	public static void main(String[] args) {
		useFinalOperator();
		testLambdaFinalValue();
	}

	/**
	 * java 8 之前，在匿名内部类中使用外部变量，必须加上final关键字
	 */
	private static void useFinalOperator() {
		Button button = new Button();
		final String world = "Hello world!";

		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("button clicked! say:" + world);
			}
		});
	}

	/**
	 * java8可以省略final关键字。
	 * 但在Lambda 引用的的是值，而不是变量，即：默认final的
	 */
	private static void testLambdaFinalValue() {
		int z = 3;
		BinaryOperator<Long> add2 = (x, y) -> {
			System.out.println("Hello BinaryOperator！z:" + z);
			// z = 4; //z是既成事实上的final，重新赋值是错误的
			return x + y;
		};

		System.out.println(add2.apply(0L, 6L));
	}

}
