package org.logan.lambda.chapter8.lambdabehave;

import org.logan.lambda.chapter8.lambdabehave.expectations.Expect;

/**
 * desc:  <br/>
 * time: 2020/6/23 3:07 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class Description {

	private final String suite;


	Description(String suite) {
		this.suite = suite;
	}

	public void should(String description, Specification specification) {
		try {
			Expect expect = new Expect();
			specification.specifyBehaviour(expect);
			Runner.current.recordSuccess(suite, description);
		} catch (AssertionError cause) {
			Runner.current.recordFailure(suite, description, cause);
		} catch (Throwable cause) {
			Runner.current.recordError(suite, description, cause);
		}
	}

}