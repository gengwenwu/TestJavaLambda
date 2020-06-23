package org.logan.lambda.chapter8.lambdabehave.reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * desc:  <br/>
 * time: 2020/6/23 3:20 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class SuiteReport {

	private final String name;
	private final List<SpecificationReport> specifications;


	public SuiteReport(String name) {
		this.name = name;
		specifications = new ArrayList<>();
	}

	public void add(SpecificationReport specification) {
		specifications.add(specification);
	}

	public Stream<SpecificationReport> specifications() {
		return specifications.stream();
	}

	public String getName() {
		return name;
	}

}