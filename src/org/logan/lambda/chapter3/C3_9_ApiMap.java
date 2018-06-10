package org.logan.lambda.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: 使用流将字符串转换为大写 <br/>
 * time: 2018/6/10 下午10:22 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_9_ApiMap {

	public static void main(String[] args) {
		List<String> collected = Stream.of("a", "b", "hello")
				.map(string -> string.toUpperCase())
				.collect(Collectors.toList());

		// TODO
		// assertEquals(asList("A", "B", "HELLO"), collected);
	}

}
