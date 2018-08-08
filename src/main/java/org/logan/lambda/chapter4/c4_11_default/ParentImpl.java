package org.logan.lambda.chapter4.c4_11_default;

/**
 * desc: {@link Parent} 实现类 <br/>
 * time: 2018/8/8 上午11:26 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class ParentImpl implements Parent {

	private String lastMessage;

	@Override
	public void message(String body) {
		lastMessage = body;
	}

	@Override
	public String getLastMessage() {
		return lastMessage;
	}

}
