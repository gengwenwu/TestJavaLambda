package org.logan.lambda.chapter8.lambdabehave.reporting;

import java.io.PrintStream;

/**
 * desc:  <br/>
 * time: 2020/6/23 3:15 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class ConsoleFormatter implements ReportFormatter {

	@Override
	public void format(Report report) {
		report.suites().forEach(suite -> {
			System.out.println(suite.getName());
			System.out.println("");
			suite.specifications().forEach(this::printSpecification);
		});
	}

	private void printSpecification(SpecificationReport specification) {
		boolean isSuccess = (specification.getResult() == Result.SUCCESS);
		PrintStream out = isSuccess ? System.out : System.err;

		out.print("\tshould ");
		out.print(specification.getDescription());
		if (!isSuccess) {
			out.print("[");
			out.print(specification.getMessage());
			out.print("]");
		}
		out.println();
	}

}