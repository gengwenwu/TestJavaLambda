package org.logan.lambda.chapter3;

import org.logan.lambda.common.helper.Button;
import org.logan.lambda.common.helper.View;

/**
 * desc: 正确使用Lambada表达式 <br/>
 * time: 2018/6/11 上午7:58 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_26_UseLambda {

	private View lastView = null;

	private void setOnClickListener() {
		Button button = new Button();

		button.setOnClickListener(view -> {
			lastView = view;
			System.out.println("button clicked!");
		});
	}


	private void setOnClickListener2() {
		Button button = new Button();
		View lastView = null;

		button.setOnClickListener(view -> {
			// 绝非编写错误。这实际上是语言的设计者有意为之，用以鼓励用户使用 Lambda 表达式获取值而不是变量。
			// clickView = view;
			System.out.println("button clicked!");
		});
	}

}
