package org.logan.lambda.chapter5.helper;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * desc: 自定义string 收集器 <br/>
 * TODO
 * StringJoiner
 * 一个自定义收集器由四部分组成，分别是： <br/>
 * 1，suppliers,这是一个工厂方法，用来创建容器。
 * time: 2018/11/11 下午5:30 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class StringCollector implements Collector<String, StringCombiner, String> {

	/**
	 * 分割
	 */
	private final String delimit;
	/**
	 * 前缀
	 */
	private final String prefix;
	/**
	 * 后缀
	 */
	private final String suffix;

	private final StringBuilder builder;

	public StringCollector(String delimit, String prefix, String suffix) {
		this.delimit = delimit;
		this.prefix = prefix;
		this.suffix = suffix;
		builder = new StringBuilder();
	}

	/**
	 * 创建容器，譬如:{@link StringCombiner} , 和 reduce 操作中的第一个参数类似。
	 */
	@Override
	public Supplier<StringCombiner> supplier() {
		return () -> new StringCombiner(delimit, prefix, suffix);
	}

	/**
	 * accumulator() 的作用和 reduce 操作的第二个参数一样
	 */
	@Override
	public BiConsumer<StringCombiner, String> accumulator() {
		return StringCombiner::add;
	}

	@Override
	public BinaryOperator<StringCombiner> combiner() {
		return StringCombiner::merge;
	}

	@Override
	public Function<StringCombiner, String> finisher() {
		return StringCombiner::toString;
	}

	// 特征
	@Override
	public Set<Characteristics> characteristics() {
		return Collections.unmodifiableSet(Collections.emptySet());
	}

}
