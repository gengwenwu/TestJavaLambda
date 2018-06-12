package org.logan.lambda.chapter3;

import junit.framework.TestCase;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * flatMap: TODO <br/>
 * time: 2018/6/11 上午6:59 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_12_StreamApiFlatMap {

	public static void main(String[] args) {
		// 例3-12 包含多个列表的 Stream
		List<Integer> together = Stream.of(asList(1, 2), asList(3, 4))
				.flatMap(numbers -> numbers.stream())
				.collect(Collectors.toList());

		TestCase.assertEquals(asList(1, 2, 3, 4), together);
	}

}
