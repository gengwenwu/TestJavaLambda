package org.logan.lambda.chapter3;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * reduce: 可以实现从一组值中生成一个值。<br/>
 * time: 2018/6/11 上午7:22 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_16_StreamApiReduce {

	public static void main(String[] args) {
		sumByStreamReduceMode();
		// explodeReduce();
		// sumByCommandMode();
	}

	private static void sumByStreamReduceMode() {
		int count = Stream.of(1, 2, 3)
				.reduce(0, (acc, element) -> acc + element);

		TestCase.assertEquals(6, count);
	}

	/**
	 * 展开Reduce
	 */
	private static void explodeReduce() {
		BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
		int count = accumulator.apply(
				accumulator.apply(
						accumulator.apply(0, 1),
						2),
				3);
		System.out.println("explodeReduce() -> count:" + count);
	}

	/**
	 * 使用命令方式
	 */
	private static void sumByCommandMode() {
		int acc = 0;
		for (Integer element : Arrays.asList(1, 2, 3)) {
			acc = acc + element;
		}

		TestCase.assertEquals(6, acc);
	}

}
