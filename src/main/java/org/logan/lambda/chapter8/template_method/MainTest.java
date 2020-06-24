package org.logan.lambda.chapter8.template_method;

import org.logan.lambda.chapter8.template_method.lambdas.Company;
import org.logan.lambda.chapter8.template_method.lambdas.CompanyLoanApplication2;
import org.logan.lambda.chapter8.template_method.lambdas.Personal;
import org.logan.lambda.chapter8.template_method.lambdas.PersonalLoanApplication2;
import org.logan.lambda.chapter8.template_method.traditional.CompanyLoanApplication;
import org.logan.lambda.chapter8.template_method.traditional.EmployeeLoanApplication;
import org.logan.lambda.chapter8.template_method.traditional.PersonalLoanApplication;

/**
 * desc: 测试模式 测试类 <br/>
 * time: 2020/6/22 5:33 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class MainTest {

	public static void main(String[] args) {
		runByJavaNormal();
		runByLambda();
	}

	// java 普通方式
	private static void runByJavaNormal() {
		new CompanyLoanApplication().checkLoanApplication();
		new PersonalLoanApplication().checkLoanApplication();
		new EmployeeLoanApplication().checkLoanApplication();
	}

	// lambda 方式
	private static void runByLambda() {
		new CompanyLoanApplication2(new Company()).checkLoanApplication();
		new PersonalLoanApplication2(new Personal()).checkLoanApplication();
	}

}