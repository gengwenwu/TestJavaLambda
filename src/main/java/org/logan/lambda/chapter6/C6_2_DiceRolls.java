package org.logan.lambda.chapter6;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

/**
 * desc: 模拟投掷骰子 <br/>
 * time: 2019/3/23 下午9:04 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class C6_2_DiceRolls {

	private static final int N = 100000000;//一亿次

	public static void main(String[] ignore) {
		System.out.println("serial begin...");
		long time = System.currentTimeMillis();
		print(serialDiceRolls());
		System.out.println("serial end。==========> useTime:" + (System.currentTimeMillis() - time));

		System.out.println("");
		System.out.println("========");
		System.out.println("");

		System.out.println("parallel begin...");
		time = System.currentTimeMillis();
		print(parallelDiceRolls());
		System.out.println("parallel end。==========> useTime:" + (System.currentTimeMillis() - time));
	}

	private static Map<Integer, Double> serialDiceRolls() {
		double fraction = 1.0 / N;
		return IntStream.range(0, N)
				.mapToObj(twoDiceThrows())
				.collect(groupingBy(side -> side, summingDouble(n -> fraction)));
	}

	private static Map<Integer, Double> parallelDiceRolls() {
		double fraction = 1.0 / N;
		return IntStream.range(0, N)  // <1>
				.parallel()   // <2>
				.mapToObj(twoDiceThrows())  // <3>
				.collect(groupingBy(side -> side   // <4>
						, summingDouble(n -> fraction)));  // <5>
	}

	private static IntFunction<Integer> twoDiceThrows() {
		return i -> {
			ThreadLocalRandom random = ThreadLocalRandom.current();
			int firstThrow = random.nextInt(1, 7);
			int secondThrow = random.nextInt(1, 7);
			return firstThrow + secondThrow;
		};
	}

	private static void print(Map<Integer, Double> map) {
		map.forEach((number, fraction) ->
				System.out.println(number + "=" + fraction)
		);
	}

}
