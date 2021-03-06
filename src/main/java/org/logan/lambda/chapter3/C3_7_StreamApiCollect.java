package org.logan.lambda.chapter3;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: Stream collect()：将流里的值生成列表 <br/>
 * time: 2018/6/10 下午10:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_7_StreamApiCollect {

	public static void main(String[] args) {
		List<String> collected = Stream.of("a", "b", "c")
				.collect(Collectors.toList());

		TestCase.assertEquals(Arrays.asList("a", "b", "c"), collected);
	}

}
