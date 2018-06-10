package org.logan.lambda.chapter3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: TODO <br/>
 * time: 2018/6/10 下午10:32 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_11_StreamApiFilter {

	public static void main(String[] args) {
		List<String> beginningWithNumbers = Stream.of("a", "b", "hello")
				.filter(value -> Character.isDigit(value.charAt(0)))
				.collect(Collectors.toList());

		// TODO
		// assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
	}

}
