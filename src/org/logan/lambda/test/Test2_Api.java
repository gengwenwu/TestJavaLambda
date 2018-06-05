package org.logan.lambda.test;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.logan.lambda.common.LogUtil.printEmptyLine;

/**
 * desc: Lambda课程二 -- 常用流Api <br/>
 * time: 2018/4/18 下午7:29 <br/>
 * author: 居廉 <br/>
 * since V 1.0 <br/>
 */
class Test2_Api {

	private static String[] animalsArray = {"Ant", "Bear", "Cat", "Dog", "fish", "Monkey"};
	private static int[] numberArray = {12, 18, 22, 22, 22, 50};

	// 流：Java 8中新增的对核心类库的改进主要包括集合类的 API 和新引入的流 (Stream)。
	//
	public static void main(String[] args) {
		testIterator();
		testCreateStream();
		testLazyAndEager();
		testFilter();
		testDistinct();
		testLimit();
		testSkip();
		testMap();
		testFlatMap();
		testMaxAndMin();
		testReduce();

		testOptional();
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

		printEmptyLine();
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

		printEmptyLine();
	}

	/**
	 * collect：（Collectors.toList()） <br/>
	 * 将stream里的值生成一个列表，也就是将流再转化成为集合，是一个及早求值的操作。 <br/>
	 */
	private static void testCollect() {
		List<Integer> lists = Arrays.asList(1, 13, 15, 20);
		lists.stream() // 将集合转化成流
				.filter(it -> it == 20).map(it -> it + 10) //一系列惰性求值的操作,返回值为stream
				.collect(Collectors.toList()); //及早求值，再将流转化为集合。

		printEmptyLine();
	}

	/**
	 * 通常,在 Java中调用一个方法,计算机会立即执行操作，如：System.out.printEmptyLine()。 <br/>
	 * Stream里的一些方法却略有不同，它们虽是普通的Java方法，但返回的Stream对象却不是一个新集合,而是创建新集合的配方。<br/>
	 * 判断一个操作是惰性求值还是及早求值很简单:只需看它的返回值。 <br/>
	 * 如果返回值是 Stream, 那么是惰性求值;如果返回值是另一个值或为空,那么就是及早求值。 <br/>
	 * 使用这些操作的理想方式就是形成一个惰性求值的链,最后用一个及早求值的操作返回想要的结果,这正是 它的合理之处。 <br/>
	 */
	private static void testLazyAndEager() {
		// 惰性求值方法(lazy):像下面的filter。
		// 及早求值方法:如count
		long count = SampleData.allArtists.stream().filter(artist -> {
			// System.out.printEmptyLine("== artist filter");
			return artist.isFrom("London");
		}).count();

		System.out.println("testLazyAndEager() -> count:" + count);
		printEmptyLine();
	}

	/**
	 * filter：接收一个Lambda表达式作为参数，该表达式返回boolean，<br/>
	 * 在执行过程中，流将元素逐一输送给filter，并筛选出执行结果为true的元素。<br/>
	 */
	private static void testFilter() {
		long count = Arrays.stream(numberArray).filter(it -> it > 18).count();
		System.out.println("testFilter() -> count:" + count);
		printEmptyLine();
	}

	/**
	 * distinct：去重 <br/>
	 * 注意：对一个自定义的class使用distinct()，切记覆写equals()和hashCode()，否则distinct不生效。<br/>
	 */
	private static void testDistinct() {
		/*
		long count = SampleData.allArtists.stream()
				.filter(artist -> artist.isFrom("UK"))
				.distinct()
				.count();*/

		long count = Arrays.stream(numberArray).distinct().count();
		System.out.println("testDistinct() -> count:" + count);
		printEmptyLine();
	}

	/**
	 * limit：截取流的前N个元素
	 */
	private static void testLimit() {
		int limit = 2;
		List<String> animalsList = Arrays.stream(animalsArray).limit(limit).collect(Collectors.toList());
		System.out.println("testLimit(" + limit + ") -> value:");
		animalsList.stream().forEach(System.out::println);
		printEmptyLine();
	}

	/**
	 * skip：跳过流的前N个元素：
	 */
	private static void testSkip() {
		int skip = 3;
		System.out.println("testSkip(" + skip + ") -> value:");
		Arrays.stream(animalsArray).skip(skip).forEach(System.out::println);
		printEmptyLine();
	}

	/**
	 * test：将一种类型的值转换成另外一种类型，即：将一个流中的值转换成一个新的流。
	 */
	private static void testMap() {
		List<String> artistNames = SampleData.allArtists.stream()
				.map(it -> it.getName()) //将艺术家集合映射成了包含艺术家名字的集合
				.collect(Collectors.toList());
		System.out.println("testMap() -> artist names :");
		artistNames.stream().forEach(System.out::println);

		int[] array = {1, 3, 5, 8, 9};
		List<Integer> lists = Arrays.stream(array)
				.map(it -> {
					if (it == 9) {
						it = 99;
					}
					return it; //todo 为什么不能转换成String类型？
				}).boxed().collect(Collectors.toList());

		System.out.println("testMap() -> array value:");
		lists.stream().forEach(System.out::println);
		printEmptyLine();
	}

	/**
	 * flatMap：将一条一条的小流(stream)，汇聚成一条大流(stream)，好比海纳百川的感觉。<br/>
	 * 在java8里，你可以理解成流水线，流水线的上的商品就是集合里一个个的元素，<br/>
	 * 而这些对于流的各种各样的流操作，就是流水线上加工这些商品的机器。所以，stream流的相关特性:不可逆 <br/>
	 */
	private static void testFlatMap() {
		List<Integer> list = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());

		list.forEach(n -> System.out.println("testFlatMap() -> n:" + n));
		printEmptyLine();
	}

	/**
	 * Max：求最大 <br/>
	 * min：求最小 <br/>
	 * 事实上在实际操作的时候我并不会选择这种操作方式 todo
	 */
	private static void testMaxAndMin() {
		int[] array = {1, 3, 5, 8, 9};
		System.out.println("testFilter()" +
				" -> maxValue:" + Arrays.stream(array).max().getAsInt()
				+ ", minValue:" + Arrays.stream(array).min().getAsInt());
		printEmptyLine();
	}

	/**
	 * reduce：可以实现从一组值中生成一个值。
	 * 其实count，min，max方法都是由reduce操作实现的。
	 */
	private static void testReduce() {
		//reduce函数接收两个参数：
		// 1, 初始值
		// 2, 进行归约操作的Lambda表达式。它接收一个拥有两个参数的Lambda表达式，
		//    以上代码acc参数代表当前的数值总和，element代表下一个元素，reduce会把流中的元素两两输给Lambda表达式，最后将计算出累加之和。

		int count = Stream.of(1, 2, 3)
				.reduce(0, (acc, element) -> {
					System.out.println("testReduce() -> acc:" + acc + ", element:" + element);
					return acc + element; //每次acc + element的返回值都会赋给acc
				});
		System.out.println("testReduce() count:" + count);


		// 如果当前流的元素为数值类型，那么可以使用Integer提供了sum函数代替自定义的Lambda表达式
		int age = Stream.of(11, 12, 13)
				.reduce(0, Integer::sum); //Integer类还提供了min、max等一系列数值操作，当流中元素为数值类型时可以直接使用。
		System.out.println("testReduce() -> age:" + age);

		printEmptyLine();
	}


	private static void testOptional() {
		Optional empty = Optional.ofNullable("abc"); //可以接受null
		// Optional empty2 = Optional.of(null);//不能接受null

		if (empty.isPresent()) { //isPresent(): 非null为true
			//get(): 如果Optional有值则将其返回，否则抛出NoSuchElementException。
			System.out.println("testOptional() -> " + empty.get());
		} else {
			System.out.println("testOptional() -> empty 为null！");
		}

		// ifPresent：如果Optional实例有值，则为其调用consumer，否则不做处理
		empty.ifPresent(value -> {
			System.out.println("testOptional() ->ifPresent() value:" + value);
		});

		// orElse：如果有值则将其返回，否则返回指定的其它值，如："为空的默认值"
		System.out.println("testOptional() -> orElse('为空的默认值。') value:" + empty.orElse(("为空的默认值")));
	}

}