package org.logan.lambda.test.reflect.model;

/**
 * desc: TODO <br/>
 * time: 2019/6/21 下午3:10 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public class ModelA extends BaseModel {

	@Curr
	private String currency;

	private boolean isOk;

	public ModelA() {

	}

	public ModelA(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean ok) {
		isOk = ok;
	}
}
