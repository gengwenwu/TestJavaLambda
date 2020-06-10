package org.logan.lambda.chapter7;

import java.util.List;
import java.util.stream.Collectors;

/**
 * desc: 单元测试 与 lambda - 优化C7_8_Testing.java <br/>
 * time: 2020/6/10 2:21 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C7_12_Testing {

	public static List<String> elementFirstToUpperCaseLambdas(List<String> words) {
		return words.stream()
				.map(C7_12_Testing::firstToUppercase) // 使用方法引用
				.collect(Collectors.toList());
	}


	// 首字母转大写。抽取一个方法，再配合方法引用，方便单元测试
	public static String firstToUppercase(String value) {
		char firstChar = Character.toUpperCase(value.charAt(0));
		return firstChar + value.substring(1);
	}

}