package org.logan.lambda.chapter6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * desc: 并行求和 <br/>
 * time: 2019/3/23 下午9:33 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class C6_5_IntegerSum {

	// 100万次
	private static final int size = Integer.getInteger("sum.size", 1000000);

	private int[] array;
	private List<Integer> arrayList;
	private LinkedList<Integer> linkedList;
	private TreeSet<Integer> treeSet;
	private HashSet<Integer> hashSet;

	public static void main(String[] args) {
		C6_5_IntegerSum instance = new C6_5_IntegerSum();
		instance.createDataSources();

		// int 求和操作
		instance.addIntegers(instance.arrayList);

		// 不同数据源，串行、并行执行效率比较
		instance.compareSerialParallel();
	}

	private void createDataSources() {
		System.out.println("开始创建数据 begin...");
		array = IntStream.range(0, size).toArray();
		arrayList = numbers().collect(toList());
		linkedList = new LinkedList<>(arrayList);
		treeSet = new TreeSet<>(arrayList);
		hashSet = new HashSet<>(arrayList);
		System.out.println("创建数据完成========");
	}

	private void compareSerialParallel() {
		/* 并行 */
		C6_1_StreamParallel.recordMethodUsedTime("parallel sum IntStream.range", this::range);
		C6_1_StreamParallel.recordMethodUsedTime("parallel sum array", this::array);
		C6_1_StreamParallel.recordMethodUsedTime("parallel sum arrayList", this::arrayList);
		C6_1_StreamParallel.recordMethodUsedTime("parallel sum linkedList", this::linkedList);
		C6_1_StreamParallel.recordMethodUsedTime("parallel sum treeSet", this::treeSet);
		C6_1_StreamParallel.recordMethodUsedTime("parallel sum hashSet", this::hashSet);

		System.err.println("");

			/* 串行 */
		C6_1_StreamParallel.recordMethodUsedTime("serial sum IntStream.range", this::serialRange);
		C6_1_StreamParallel.recordMethodUsedTime("serial sum array", this::serialArray);
		C6_1_StreamParallel.recordMethodUsedTime("serial sum arrayList", this::serialArrayList);
		C6_1_StreamParallel.recordMethodUsedTime("serial sum linkedList", this::serialLinkedList);
		C6_1_StreamParallel.recordMethodUsedTime("serial sum treeSet", this::serialTreeSet);
		C6_1_StreamParallel.recordMethodUsedTime("serial sum hashSet", this::serialHashSet);
	}


	//========== parallel
	private int range() {
		return IntStream.range(0, size).parallel().sum();
	}

	private int array() {
		return IntStream.of(array).parallel().sum();
	}

	private int arrayList() {
		return arrayList.parallelStream().mapToInt(i -> i).sum();
	}


	private int linkedList() {
		return linkedList.parallelStream().mapToInt(i -> i).sum();
	}

	private int treeSet() {
		return treeSet.parallelStream().mapToInt(i -> i).sum();
	}

	private int hashSet() {
		return hashSet.parallelStream().mapToInt(i -> i).sum();
	}

	//========== serial
	private int serialRange() {
		return IntStream.range(0, size).sum();
	}

	private int serialArray() {
		return IntStream.of(array).sum();
	}

	private int serialArrayList() {
		return arrayList.stream().mapToInt(i -> i).sum();
	}

	private int serialLinkedList() {
		return linkedList.stream().mapToInt(i -> i).sum();
	}

	private int serialTreeSet() {
		return treeSet.stream().mapToInt(i -> i).sum();
	}

	private int serialHashSet() {
		return hashSet.stream().mapToInt(i -> i).sum();
	}


	//========== 其它
	private Stream<Integer> numbers() {
		return IntStream.range(0, size).mapToObj(i -> i);
	}

	private int addIntegers(List<Integer> values) {
		return values.parallelStream()
				.mapToInt(i -> i)
				.sum();
	}

}
