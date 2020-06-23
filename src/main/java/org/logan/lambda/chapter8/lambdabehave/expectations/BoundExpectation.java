package org.logan.lambda.chapter8.lambdabehave.expectations;

import static org.junit.Assert.assertEquals;

/**
 * desc:  <br/>
 * time: 2020/6/23 2:54 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class BoundExpectation {

	private final Object objectUnderTest;


	public BoundExpectation(Object value) {
		this.objectUnderTest = value;
	}

	public void isEqualTo(Object expected) {
		assertEquals(expected, objectUnderTest);
	}

}