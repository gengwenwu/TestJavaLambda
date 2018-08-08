package org.logan.lambda.chapter4.c4_11_default;

/**
 * desc: 继承 {@link Parent} 接口 <br/>
 * time: 2018/8/8 上午11:30 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
interface Child extends Parent {

	@Override
	default void welcome() {
		message("Child: Hi!");
	}

}
