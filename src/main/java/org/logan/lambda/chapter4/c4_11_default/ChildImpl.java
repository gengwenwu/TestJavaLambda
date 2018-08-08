package org.logan.lambda.chapter4.c4_11_default;

/**
 * desc: {@link Child} 实现类 <br/>
 * time: 2018/8/8 上午11:48 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class ChildImpl implements Child {

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
