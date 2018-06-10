package org.logan.lambda.chapter3;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * desc: java8 reduce todo <br/>
 * time: 2018/6/11 上午7:22 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_16_StreamApiReduce {

	public static void main(String[] args) {
		int count = Stream.of(1, 2, 3)
				.reduce(0, (acc, element) -> acc + element);
		// TODO
		// assertEquals(6, count);


		explodeReduce();
	}

	private static void explodeReduce() {
		BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
		int count = accumulator.apply(
				accumulator.apply(
						accumulator.apply(0, 1),
						2),
				3);
		System.out.println("explodeReduce() -> count:" + count);
	}

}
