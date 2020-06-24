package org.logan.lambda.chapter8.template_method.traditional;

/**
 * desc: 内部员工贷款 <br/>
 * time: 2020/6/22 6:30 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class EmployeeLoanApplication extends PersonalLoanApplication {

	@Override
	protected void checkIncomeHistory() {
		// They work for us!
	}

}