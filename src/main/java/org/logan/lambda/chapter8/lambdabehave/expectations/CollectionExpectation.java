package org.logan.lambda.chapter8.lambdabehave.expectations;

import java.util.Collection;

import static org.junit.Assert.assertTrue;

/**
 * desc:  <br/>
 * time: 2020/6/23 3:02 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class CollectionExpectation extends BoundExpectation {

	private final Collection<?> objectUnderTest;


	public CollectionExpectation(Collection<?> value) {
		super(value);
		this.objectUnderTest = value;
	}

	public void isEmpty() {
		assertTrue(objectUnderTest.isEmpty());
	}

}