package org.logan.lambda.chapter7;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * desc:  C7_12_Testing.java 单元测试。 <br/>
 * time: 2020/6/10 2:34 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class C7_12_TestingTest {

	@Test
	public void firstToUppercase() {
		String input = "ab";
		String result = C7_12_Testing.firstToUppercase(input);
		assertEquals("Ab", result);
	}

}