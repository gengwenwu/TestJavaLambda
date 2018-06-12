package org.logan.lambda.chapter3;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map: 将一种类型的值转换成另外一种类型，即：将一个流中的值转换成一个新的流。 <br/>
 * time: 2018/6/10 下午10:22 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_9_StreamApiMap {

	public static void main(String[] args) {
		List<String> collected = Stream.of("a", "b", "hello")
				.map(string -> string.toUpperCase()) //使用流将字符串转换为大写
				.collect(Collectors.toList());

		TestCase.assertEquals(Arrays.asList("A", "B", "HELLO"), collected);
	}

}
