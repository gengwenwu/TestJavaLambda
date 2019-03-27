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
		{
			/* 串行、并行数组 赋值 测试*/
			int count = 100000000; // 1亿次

			C6_1_StreamParallel.recordMethodUsedTime(" 串行 初始化数组", () -> imperativeInitilize(count));
			C6_1_StreamParallel.recordMethodUsedTime(" 并行 初始化数组", () -> parallelInitialize(count));
			System.err.println("");
		}


		{
			/* Arrays.parallelPrefix();  测试 */
//			double[] numbers = {0, 1, 2, 3, 4, 3.5};
//			double[] result = simpleMovingAverage(numbers, 3);
//
//			System.out.println("");
//			for (double num : result) {
//				System.out.print(num + " ");
//			}
		}

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
		Arrays.parallelSetAll(values, i -> i); //使用这些方法要小心：它们改变了传入的数组，而没有创建一个新的数组。
		return values;
	}

	/**
	 * 求滑动平均数
	 *
	 * @param n 滑动窗口
	 */
	private static double[] simpleMovingAverage(double[] values, int n) {
		double[] sums = Arrays.copyOf(values, values.length); // <1>
		Arrays.parallelPrefix(sums, Double::sum); // <2> //改变了传入的数组，而没有创建一个新的数组。

		for (double num : sums) {
			System.out.print(num + " ");
		}
//		System.out.println("");

		int start = n - 1;
		return IntStream.range(start, sums.length) // <3>
				.mapToDouble(i -> {
					double prefix = (i == start) ? 0 : sums[i - n];
					// System.out.println("i:" + i + ", start:" + start + ", prefix:" + prefix + ", i-n:" + (i - n));
					return (sums[i] - prefix) / n; // <4>
				})
				.toArray(); // <5>
	}

}
