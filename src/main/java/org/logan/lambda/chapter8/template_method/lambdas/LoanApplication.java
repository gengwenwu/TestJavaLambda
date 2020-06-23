package org.logan.lambda.chapter8.template_method.lambdas;

/**
 * desc: 模板方法模式 - 描述申请贷款过程 <br/>
 * time: 2020/6/23 11:30 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
abstract class LoanApplication {

	/* Criteria 是函数接口，方便抽离实现类，而且可以使用lambda表达式 或方法引用 */
	private final Criteria identity;
	private final Criteria creditHistory;
	private final Criteria incomeHistory;


	public LoanApplication(Criteria identity, Criteria creditHistory, Criteria incomeHistory) {
		this.identity = identity;
		this.creditHistory = creditHistory;
		this.incomeHistory = incomeHistory;
	}

	public void checkLoanApplication() {
		// 模版方法
		identity.check();
		creditHistory.check();
		incomeHistory.check();

		reportFindings();
	}

	private void reportFindings() {

	}

}