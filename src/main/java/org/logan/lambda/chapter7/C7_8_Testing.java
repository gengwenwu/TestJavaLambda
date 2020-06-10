package org.logan.lambda.chapter7;

import java.util.List;
import java.util.stream.Collectors;

/**
 * desc: 单元测试 与 lambda。 优化见：C7_12_Testing.java <br/>
 * time: 2020/6/10 2:21 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C7_8_Testing {

	// 全部转大写
	public static List<String> allToUpperCase(List<String> words) {
		return words.stream()
				.map(String::toUpperCase)
				.collect(Collectors.toList());
	}

	// 首字母转大写
	public static List<String> elementFirstToUpperCaseLambdas(List<String> words) {
		return words.stream()
				.map(value -> {
							char firstChar = Character.toUpperCase(value.charAt(0));
							return firstChar + value.substring(1);
						}
				).collect(Collectors.toList());
	}

}