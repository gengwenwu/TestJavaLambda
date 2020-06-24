package org.logan.lambda.chapter8.template_method.lambdas;

/**
 * desc: 公司业务申请贷款过程 <br/>
 * time: 2020/6/23 11:53 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class CompanyLoanApplication2 extends LoanApplication {

	public CompanyLoanApplication2(Company company) {// 检查实现抽离到company中
		super(company::checkIdentity, // 函数引用
				company::checkHistoricalDebt,
				company::checkProfitAndLoss);
	}

}