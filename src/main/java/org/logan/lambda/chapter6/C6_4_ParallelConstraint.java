package org.logan.lambda.chapter6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * desc: 并行化 - 限制 <br/>
 * time: 2019/3/23 下午9:42 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C6_4_ParallelConstraint {

	public static void main(String[] args) {
		// reduce
		reduceParallelConstraint();

	}

	private static void reduceParallelConstraint() {
		ArrayList<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(1, 2, 3, 4));
		list.add(Arrays.asList(2, 3, 4, 5));
		list.add(Arrays.asList(3, 4, 5, 6));

		final int identity = 0;

		// 非并行流
		Integer reduce1 = list.stream()
				.flatMap(Collection::stream)
				.reduce(identity
						, (acc, ele) -> acc + ele
						, (u, t) -> {
							// 非并行流，不会执行第三个参数
							// System.out.println("u----:" + u);
							return null; // 这里的返回值并没有影响返回结果
						});
		System.out.println("======》 reduce1:" + reduce1);

		// 并行流
		Integer reduce2 = list.parallelStream()
				.flatMap(Collection::stream)
				.reduce(identity
						, (acc, ele) -> acc + ele
						, (u, t) -> {
							// u，t分别为并行流, 每个子任务的结果
							// System.out.println("u:" + u + ", t:" + t);
							return u + t;
						});
		System.out.println("======》 reduce2:" + reduce2);
	}

}
