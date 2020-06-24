package org.logan.lambda.chapter8.template_method.lambdas;

/**
 * desc: 私人贷款申请流程 <br/>
 * time: 2020/6/23 1:58 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class PersonalLoanApplication2 extends LoanApplication {

	public PersonalLoanApplication2(Personal personal) {
		super(personal::checkIdentity,
				personal::checkHistoricalDebt,
				personal::checkProfitAndLoss);
	}

}