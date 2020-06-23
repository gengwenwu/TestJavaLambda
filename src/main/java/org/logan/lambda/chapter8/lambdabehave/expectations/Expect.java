package org.logan.lambda.chapter8.lambdabehave.expectations;

import java.util.Collection;

/**
 * desc:  <br/>
 * time: 2020/6/23 3:05 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public final class Expect {

	public BoundExpectation that(Object value) {
		return new BoundExpectation(value);
	}

	public CollectionExpectation that(Collection<?> collection) {
		return new CollectionExpectation(collection);
	}

}