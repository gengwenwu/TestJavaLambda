package org.logan.lambda.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * desc: 使用 for 循环条件过滤，Java8 之前的做法 <br/>
 * time: 2018/6/10 下午10:28 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_10_IteratorFilter {

	public static void main(String[] args) {
		List<String> beginningWithNumbers = new ArrayList<>();
		for (String value : Arrays.asList("a", "1abc", "abc1")) {
			if (Character.isDigit(value.charAt(0))) { // 条件过滤
				beginningWithNumbers.add(value);
			}
		}

		// TODO
		// assertEquals(asList("1abc"), beginningWithNumbers);
	}

}
