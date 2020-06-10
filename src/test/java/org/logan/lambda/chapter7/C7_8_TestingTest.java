package org.logan.lambda.chapter7;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


/**
 * desc: C7_8_Testing.java 单元测试。优化见：C7_12_TestingTest <br/>
 * time: 2020/6/10 2:26 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class C7_8_TestingTest {

	@Test
	public void allToUpperCase1() {
		List<String> input = Arrays.asList("a", "b", "hello");
		List<String> result = C7_8_Testing.allToUpperCase(input);
		assertEquals(Arrays.asList("A", "B", "HELLO"), result);
	}

	@Test
	public void elementFirstToUpperCaseLambdas1() {
		List<String> input = Arrays.asList("ab");
		List<String> result = C7_8_Testing.elementFirstToUpperCaseLambdas(input);
		assertEquals(Arrays.asList("Ab"), result);
	}

}