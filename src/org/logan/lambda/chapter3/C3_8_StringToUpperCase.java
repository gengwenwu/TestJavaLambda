package org.logan.lambda.chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 使用 for 循环将字符串转换为大写，Java8 之前的做法 <br/>
 * time: 2018/6/10 下午10:18 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_8_StringToUpperCase {

	public static void main(String[] args) {
		List<String> collected = new ArrayList<>();
		for (String string : Arrays.asList("a", "b", "hello")) {
			String uppercaseString = string.toUpperCase();
			collected.add(uppercaseString);
		}

		// TODO
		// assertEquals(asList("A", "B", "HELLO"), collected);
	}

}
