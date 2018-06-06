package org.logan.lambda.chapter2;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.IntToLongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static org.logan.lambda.common.LogUtil.printEmptyLine;

/**
 * 每一个Lambda都能通过一个特定的"函数接口"与一个"给定的类型"进行匹配。 <br/>
 * 因此一个Lambda表达式能被应用在与其目标类型匹配的任何地方，Lambda表达式必须和函数接口的抽象函数描述一样的参数类型， <br/>
 * 它的返回类型也必须和抽象函数的返回类型兼容，并且它能抛出的异常也仅限于在函数的描述范围中。 <br/>
 * Java8中定义了几十种的函数接口，其中重要的6个函数接口：Predicate、Consumer、Function、Supplier、UnaryOperator、BinaryOperator。 <br/>
 * 其它函数接口是这6个函数接口的变种，大多为限制参数类型，数量。 <br/>
 * 参考：http://www.cnblogs.com/invoker-/p/7709052.html
 * time: 2018/4/26 上午11:24 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C2_8_FunctionalInterface {

	public static void main(String[] args) {
		testFunction();
		printEmptyLine();

		testConsumer();
		printEmptyLine();

		testSupplier();
		printEmptyLine();

		testPredicate();
		printEmptyLine();

		testIntPredicate();
		printEmptyLine();

		testIntToDoubleFunction();
		printEmptyLine();

		testBiFunction();
		printEmptyLine();

		testBiFunction();
		testBinaryOperator();
	}

	//========== 1，Function接口 begin ==========//

	/**
	 * 测试 Function 函数接口。
	 * Function接口：针对 接受一个T类型参数，返回R类型的结果的方法的抽象，
	 * 通过调用apply()执行这段行为。
	 */
	private static void testFunction() {
		int x = 1;

		// 将addOne方法作为参数传递
		int y = oper(x, z -> addOne(z));
		//int y = oper(x, Test4_FunctionApi::addOne);
		System.out.printf("testFunction() -> x= %d, y = %d \r\n", x, y); // 打印结果 x=1, y=2

		/* 使用lambda表达式来表示这段行为，只要保证一个参数,一个返回值就能匹配 */
		y = oper(x, z -> z + 3);
		System.out.printf("testFunction() -> x= %d, y = %d \n", x, y); // 打印结果 x=1, y=4

		y = oper(x, z -> z * 3);
		System.out.printf("testFunction() -> x= %d, y = %d \n", x, y); // 打印结果 x=1, y=3
	}

	/**
	 * 方法第二个参数接受一个function类型的行为,然后调用apply，对a执行这段行为。
	 */
	private static int oper(int a, Function<Integer, Integer> action) {
		return action.apply(a);
	}

	private static int addOne(int a) {
		return a + 1;
	}

	//========== 2，Consumer接口 begin  ==========//

	/**
	 * 测试 Consumer 函数接口 <br/>
	 * 接收一个参数，没有返回值，可以通俗的理解成将这个参数'消费掉了'，
	 * 一般来说使用Consumer接口往往伴随着一些期望状态的改变或者事件的发生，
	 * 例如最典型的forEach就是使用的Consumer接口，虽然没有任何的返回值，但是却向控制台输出了语句。
	 * 使用accept()执行这段行为。
	 */
	private static void testConsumer() {
		Consumer<String> printString = s -> System.out.println(s);
		printString.accept("testConsumer() -> Hello World!"); //控制台输出 helloWorld!
	}

	//========== 3，Supplier begin  ==========//

	/**
	 * 测试 Supplier 函数接口 <br/>
	 * 不接受参数，但是提供一个返回值，通俗的理解为这种接口是无私的奉献者，
	 * 不仅不要参数，还返回一个值，使用get()获得这个返回值。
	 */
	private static void testSupplier() {
		Supplier<String> getInstance = () -> "Hello World!";
		System.out.println("testSupplier() -> " + getInstance.get());  // 控偶值台输出 Hello World
	}

	//========== 4，Predicate Begin  ==========//

	/**
	 * 测试 Predicate 函数接口 <br/>
	 * 接收一个参数，返回一个Boolean类型值，用于判断和过滤。
	 * 当然你可以把他理解成特殊的Function，但是为了便于区分语义，还是单独的划了一个接口。
	 * 使用test()方法执行这段行为。
	 */
	private static void testPredicate() {
		Predicate<Integer> oddNumber = integer -> integer % 2 == 1;
		System.out.println("testPredicate() 奇数？:" + oddNumber.test(2));
	}

	//============ 5，其他的接口 begin  ==========//
	// 1, 类型限制接口
	// (1)，参数类型，例如：
	// IntPredicate, LongPredicate, DoublePredicate，这几个接口，都是在基于Predicate接口的，不同的就是他们的泛型类型分别变成了Integer,Long,Double。
	// IntConsumer, LongConsumer, DoubleConsumer比如这几个，对应的就是Consumer<Integer>,Consumer<Long>,Consumer<Double>，其余的是一样的道理。

	/**
	 * 测试 {@link IntPredicate}
	 */
	private static void testIntPredicate() {
		IntPredicate oddNumber = integer -> integer % 2 == 1;
		System.out.println("testIntPredicate() 奇数？:" + oddNumber.test(2));
	}


	// (2)，返回值类型，和上面类似，只是命名的规则上多了一个To,例如：
	// IntToDoubleFunction，IntToLongFunction, 很明显就是对应的Function<Integer,Double>与Function<Integer,Long>，其余同理。
	// 另外需要注意的是，参数限制与返回值限制的命名唯一不同就是To。简单来说，前面不带To的都是参数类型限制，带To的是返回值类型限制。

	/**
	 * 测试 {@link IntToLongFunction}
	 */
	private static void testIntToDoubleFunction() {
		IntToLongFunction function = integer -> integer + Integer.MAX_VALUE;
		System.out.println("testIntToDoubleFunction() Integer最大值加10值为:" + function.applyAsLong(10));
	}


	// 2, 数量限制接口
	// 有些接口需要接受两名参数，此类接口的所有名字前面都是附加上Bi,是Binary的缩写，开头也介绍过这个单词了，是二元的意思，
	// 例如BiPredicate, BiFunction等等，而由于java没有多返回值的设定，所以BI指的都是参数为两个。

	/**
	 * 测试 {@link BiFunction}
	 */
	public static void testBiFunction() {
		BiFunction<Integer, Long, String> addResultStr = (integer, aLong) -> "结果是:" + integer + aLong;
		System.out.println("testBinaryOperator() :" + addResultStr.apply(1, 2L));
	}


	// 3, Operator接口
	// 此类接口只有2个，分别是UnaryOperator<T>一元操作符接口，与BinaryOperator<T>二元操作符接口。
	// 这类接口属于Function接口的简写，他们只有一个泛型参数，意思是Function的参数与返回值类型相同。
	// 一般多用于操作计算，计算a + b的BiFunction如果限制条件为Integer的话，往往要这么写BiFunction<Integer, Integer, Integer> 前2个泛型代表参数，
	// 最后一个代表返回值，看起来似乎是有点繁重了,这个时候就可以用BinaryOperator<Integer>来代替了。

	/**
	 * 测试 {@link BinaryOperator}
	 */
	public static void testBinaryOperator() {
		BinaryOperator<Long> addLongs = (x, y) -> x + y;
		System.out.println("testBinaryOperator() :" + addLongs.apply(1L, 2L));
	}

}
