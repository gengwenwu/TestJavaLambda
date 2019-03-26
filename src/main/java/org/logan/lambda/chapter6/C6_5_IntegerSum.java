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
	}

	private void createDataSources() {
		System.out.println("begin...");
		long time = System.currentTimeMillis();
		array = IntStream.range(0, size).toArray();
		arrayList = numbers().collect(toList());
		System.out.println("end. useTime:" + (System.currentTimeMillis() - time));

		time = System.currentTimeMillis();
		linkedList = new LinkedList<>(arrayList);
		treeSet = new TreeSet<>(arrayList);
		hashSet = new HashSet<>(arrayList);
		System.out.println("end. useTime:" + (System.currentTimeMillis() - time));
	}

	private Stream<Integer> numbers() {
		return IntStream.range(0, size).mapToObj(i -> i);
	}

	public int range() {
		return IntStream.range(0, size).parallel().sum();
	}

	public int serialRange() {
		return IntStream.range(0, size).sum();
	}

	public int array() {
		return IntStream.of(array).parallel().sum();
	}

	public int arrayList() {
		return arrayList.parallelStream().mapToInt(i -> i).sum();
	}

	private int addIntegers(List<Integer> values) {
		return values.parallelStream()
				.mapToInt(i -> i)
				.sum();
	}

	public int linkedList() {
		return linkedList.parallelStream().mapToInt(i -> i).sum();
	}

	public int treeSet() {
		return treeSet.parallelStream().mapToInt(i -> i).sum();
	}

	public int hashSet() {
		return hashSet.parallelStream().mapToInt(i -> i).sum();
	}

	public int serialArray() {
		return IntStream.of(array).sum();
	}

	public int serialArrayList() {
		return arrayList.stream().mapToInt(i -> i).sum();
	}

	public int serialLinkedList() {
		return linkedList.stream().mapToInt(i -> i).sum();
	}

	public int serialTreeSet() {
		return treeSet.stream().mapToInt(i -> i).sum();
	}

	public int serialHashSet() {
		return hashSet.stream().mapToInt(i -> i).sum();
	}

}
