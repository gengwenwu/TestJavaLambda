package org.logan.lambda.chapter3;

import junit.framework.TestCase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * flatMap：将一条一条的小流(stream)，汇聚成一条大流(stream)，好比海纳百川的感觉。<br/>
 * 在java8里，你可以理解成流水线，流水线的上的商品就是集合里一个个的元素，<br/>
 * 而这些对于流的各种各样的流操作，就是流水线上加工这些商品的机器。所以，stream流的相关特性:不可逆 <br/>
 * time: 2018/6/11 上午6:59 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_12_StreamApiFlatMap {

	public static void main(String[] args) {
		// 包含多个列表的 Stream
		List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());

		TestCase.assertEquals(asList(1, 2, 3, 4), together);
	}

}
