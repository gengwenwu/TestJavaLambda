package org.logan.lambda.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * desc: 并行化数组操作 <br/>
 * time: 2019/3/23 下午9:43 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C6_6_ArrayExamples {

	public static void main(String[] args) {
		//long time = System.currentTimeMillis();

		int count = 100000000; // 1亿次
		imperativeInitilize(count);
		parallelInitialize(count);

		// TODO: 2019/3/24  
		//simpleMovingAverage(numbers, 6);
	}

	private static double[] imperativeInitilize(int size) {
		double[] values = new double[size];
		for (int i = 0; i < values.length; i++) {
			values[i] = i;
		}
		return values;
	}

	private static double[] parallelInitialize(int size) {
		double[] values = new double[size];
		Arrays.parallelSetAll(values, i -> i);
		return values;
	}

	public static double[] simpleMovingAverage(double[] values, int n) {
		double[] sums = Arrays.copyOf(values, values.length); // <1>
		Arrays.parallelPrefix(sums, Double::sum); // <2>
		int start = n - 1;
		return IntStream.range(start, sums.length) // <3>
				.mapToDouble(i -> {
					double prefix = i == start ? 0 : sums[i - n];
					return (sums[i] - prefix) / n; // <4>
				})
				.toArray(); // <5>
	}

}
