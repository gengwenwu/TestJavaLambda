package org.logan.lambda.chapter4.c4_11_default;

/**
 * desc: 重写 {@link Parent#welcome()}  <br/>
 * time: 2018/8/8 上午11:53 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class OverridingParent extends ParentImpl {

	@Override
	public void welcome() {
		message("Class Parent: Hi!");
	}

}
