package org.logan.lambda.chapter8.lambdabehave;


import org.logan.lambda.chapter8.lambdabehave.example.StackSpec;
import org.logan.lambda.chapter8.lambdabehave.reporting.ConsoleFormatter;
import org.logan.lambda.chapter8.lambdabehave.reporting.Report;
import org.logan.lambda.chapter8.lambdabehave.reporting.ReportFormatter;
import org.logan.lambda.chapter8.lambdabehave.reporting.Result;
import org.logan.lambda.chapter8.lambdabehave.reporting.SpecificationReport;

/**
 * desc:  <br/>
 * time: 2020/6/23 3:12 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public enum Runner {

	current;


	private final Report report;


	Runner() {
		report = new Report();
	}


	void recordSuccess(String suite, String specification) {
		report.newSpecification(suite, new SpecificationReport(specification));
	}

	void recordFailure(String suite, String specification, AssertionError cause) {
		report.newSpecification(suite,
				new SpecificationReport(specification, Result.FAILURE, cause.getMessage())
		);
	}

	void recordError(String suite, String specification, Throwable cause) {
		cause.printStackTrace();
		report.newSpecification(suite,
				new SpecificationReport(specification, Result.ERROR, cause.getMessage())
		);
	}


	public static void main(String[] args) {
		current.run(StackSpec.class);
		current.printReport();
	}

	private void printReport() {
		ReportFormatter formatter = new ConsoleFormatter();
		formatter.format(report);
	}

	private void run(Class<StackSpec> stackSpecClass) {
		try {
			stackSpecClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}