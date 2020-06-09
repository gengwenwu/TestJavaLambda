package org.logan.lambda.test.reflect.model;

/**
 * desc: TODO <br/>
 * time: 2019/6/21 下午3:09 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class RemoteModel extends BaseModel {

	private String currency;
	private int code;
	private ModelA modelA;

	public RemoteModel() {

	}

	public RemoteModel(String currency, int code, ModelA modelA) {
		this.currency = currency;
		this.code = code;
		this.modelA = modelA;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public ModelA getModelA() {
		return modelA;
	}

	public void setModelA(ModelA modelA) {
		this.modelA = modelA;
	}

}
