package org.logan.lambda.chapter3;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * filter：接收一个Lambda表达式作为参数，该表达式返回boolean，<br/>
 * 在执行过程中，流将元素逐一输送给filter，并筛选出执行结果为true的元素。<br/> <br/>
 * time: 2018/6/10 下午10:32 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_11_StreamApiFilter {

	public static void main(String[] args) {
		List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
				.filter(value -> Character.isDigit(value.charAt(0)))
				.collect(Collectors.toList());

		TestCase.assertEquals(Arrays.asList("1abc"), beginningWithNumbers);
	}

}
