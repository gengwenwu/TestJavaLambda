package org.logan.lambda.chapter8.template_method.traditional;

/**
 * desc: 模板方法模式 - 描述申请贷款过程 <br/>
 * time: 2020/6/22 6:18 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
abstract class LoanApplication {

	/**
	 * 检查贷款流程
	 */
	public void checkLoanApplication() {
		checkIdentity();
		checkCreditHistory();
		checkIncomeHistory();
		reportFindings();
	}

	protected abstract void checkIdentity();

	protected abstract void checkIncomeHistory();

	protected abstract void checkCreditHistory();

	private void reportFindings() {

	}

}