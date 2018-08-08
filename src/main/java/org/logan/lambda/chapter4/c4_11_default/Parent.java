package org.logan.lambda.chapter4.c4_11_default;

/**
 * desc: Parent 接口 <br/>
 * time: 2018/8/8 上午11:21 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
interface Parent {

	void message(String body);

	String getLastMessage();

	default void welcome() {
		message("Parent: Hi!");
	}

}
