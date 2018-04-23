package org.logan.lambda.chapter1;

import org.logan.lambda.chapter1.model.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * desc: Lambda课程二 <br/>
 * time: 2018/4/18 下午7:29 <br/>
 * author: 居廉 <br/>
 * since V TODO <br/>
 */
class Test2 {

	// 流：Java 8中新增的对核心类库的改进主要包括集合类的 API 和新引入的流 (Stream)。
	//
	public static void main(String[] args) {
		testIterator();
		testCreateStream();
		testLazyAndEager();
		testFilter();
		testDistinct();
		testMaxAndMin();
		testMap();
		testReduce();
	}

	/**
	 * "外部迭代"到"内部迭代" 区别
	 * 外部迭代：需要我们程序猿手动的对这个集合进行种种操作才能得到想要结果的迭代方式，叫做外部迭代。
	 * 内部迭代：合本身内部通过流进行了处理之后，程序猿们只需要直接取结果就行了。
	 */
	private static void testIterator() {
		// 外部迭代
		int count = 0;
		for (Artist artist : SampleData.allArtists) {
			if (artist.isFrom("London")) {
				count++;
			}
		}

		// 内部迭代
		long count2 = SampleData.allArtists.stream()
				.filter(it -> it.isFrom("London"))
				.count();

		System.out.println("testIterator() -> London count:" + count + ", count2:" + count2);
	}

	/**
	 * 创建Stream
	 */
	private static void testCreateStream() {
		// 对于集合来说,直接通过stream()方法即可获取流对象
		List<Integer> lists = Arrays.asList(1, 3, 5);
		Stream<Integer> streamLists = lists.stream();
		System.out.println("testCreateStream() streamLists.count->:" + streamLists.count());

		// 对于数组来说,通过Arrays类提供的静态函数stream()获取数组的流对象
		double[] numbers = {1.1, 2.2, 3.3};
		DoubleStream streamNumbers = Arrays.stream(numbers);
		System.out.println("testCreateStream() streamNumbers.count->:" + streamNumbers.count());

		// 直接将几个普通的数值变成流对象
		Stream<String> streamApp = Stream.of("JollyChic", "Roza", "TopVid");
		System.out.println("testCreateStream() streamApp.count->:" + streamApp.count());
	}

	/**
	 * collect（Collectors.toList()） <br/>
	 * 将stream里的值生成一个列表，也就是将流再转化成为集合，是一个及早求值的操作。 <br/>
	 */
	private static void testCollect() {
		List<Integer> lists = Arrays.asList(1, 13, 15, 20);
		lists.stream() // 将集合转化成流
				.filter(it -> it == 20).map(it -> it + 10) //一系列惰性求值的操作,返回值为stream
				.collect(Collectors.toList()); //及早求值，再将流转化为集合。
	}

	/**
	 * 通常,在 Java中调用一个方法,计算机会立即执行操作，如：System.out.println()。 <br/>
	 * Stream里的一些方法却略有不同，它们虽是普通的Java方法，但返回的Stream对象却不是一个新集合,而是创建新集合的配方。<br/>
	 * 判断一个操作是惰性求值还是及早求值很简单:只需看它的返回值。 <br/>
	 * 如果返回值是 Stream, 那么是惰性求值;如果返回值是另一个值或为空,那么就是及早求值。 <br/>
	 * 使用这些操作的理想方式就是形成一个惰性求值的链,最后用一个及早求值的操作返回想要的结果,这正是 它的合理之处。 <br/>
	 */
	private static void testLazyAndEager() {
		// 惰性求值方法(lazy):像下面的filter。
		// 及早求值方法:如count
		long count = SampleData.allArtists.stream().filter(artist -> {
			// System.out.println("== artist filter");
			return artist.isFrom("London");
		}).count();

		System.out.println("count:" + count);
	}

	/**
	 * filter函数接收一个Lambda表达式作为参数，该表达式返回boolean，<br/>
	 * 在执行过程中，流将元素逐一输送给filter，并筛选出执行结果为true的元素。<br/>
	 */
	private static void testFilter() {
		int[] array = {12, 18, 22};
		long count = Arrays.stream(array).filter(it -> it > 18).count();
		System.out.println("testFilter() -> count:" + count);
	}

	/**
	 * distinct去重 <br/>
	 */
	private static void testDistinct() {
		/*
		对一个自定义的class使用distinct()，切记覆写equals()，一定要覆写hashCode()
		long count = SampleData.allArtists.stream()
				.filter(artist -> artist.isFrom("UK"))
				.distinct()
				.count();*/

		int[] array = {12, 18, 22, 22, 22};
		long count = Arrays.stream(array).distinct().count();
		System.out.println("testDistinct() -> count:" + count);
	}

	private static void testMaxAndMin() {
		int[] array = {1, 3, 5, 8, 9};
		System.out.println("testFilter() -> maxValue:" + Arrays.stream(array).max().getAsInt()
				+ ", minValue:" + Arrays.stream(array).min().getAsInt());
	}

	private static void testMap() {
		int[] array = {1, 3, 5, 8, 9};
		List<Integer> lists = Arrays.stream(array)
				.map(it -> {
					if (it == 9) {
						it = 99;
					}
					return it;
				}).boxed().collect(Collectors.toList());

		System.out.println("testMap() -> value:");
		lists.stream().forEach(System.out::println);
	}

	private static void testReduce() {
		// reduce 操作可以实现从一组值中生成一个值。
		int count = Stream.of(1, 2, 3).reduce(0, (acc, element) -> {
			System.out.println("acc:" + acc + ", element:" + element);
			return acc + element;
		});

		System.out.println("reduce count:" + count);
		List<Integer> lists = Arrays.asList(1, 2, 3, 4);
		int listCount = lists.stream().reduce(0, (acc, element) -> acc + element);
		System.out.println("listCount:" + listCount);
	}

}