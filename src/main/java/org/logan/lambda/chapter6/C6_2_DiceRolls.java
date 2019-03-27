package org.logan.lambda.chapter6;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.function.Supplier;
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
		// 串行方式
		rollDice("serial", C6_2_DiceRolls::serialDiceRolls);

		System.out.println("----------------------");

		// 并行方式
		rollDice("parallel", C6_2_DiceRolls::parallelDiceRolls);
	}

	private static Map<Integer, Double> serialDiceRolls() {
		double fraction = 1.0 / N;
		return IntStream.range(0, N)
				.mapToObj(twoDiceThrows())
				.collect(groupingBy(side -> side, summingDouble(n -> fraction)));
		// todo  side ，n？
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

	private static void rollDice(String flag, Supplier<Map<Integer, Double>> supplier) {
		System.out.println(flag + " begin...");
		long time = System.currentTimeMillis();
		print(supplier.get());
		System.out.println(flag + " end。==========> useTime:" + (System.currentTimeMillis() - time));
	}

	private static void print(Map<Integer, Double> map) {
		map.forEach((number, fraction) ->
				System.out.println(number + "=" + fraction)
		);
	}

}
