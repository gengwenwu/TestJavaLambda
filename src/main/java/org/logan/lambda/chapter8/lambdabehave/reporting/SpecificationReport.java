package org.logan.lambda.chapter8.lambdabehave.reporting;

/**
 * desc:  <br/>
 * time: 2020/6/23 3:18 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public final class SpecificationReport {

	private final String description;
	private final Result result;
	private final String message;


	public SpecificationReport(String specification) {
		this(specification, Result.SUCCESS, null);
	}

	public SpecificationReport(String description, Result result, String message) {
		this.description = description;
		this.result = result;
		this.message = message;
	}


	public String getDescription() {
		return description;
	}

	public Result getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

}