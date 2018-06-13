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


	private void test1() {
		Button button = new Button();

		// 创建了View.OnClickListener匿名内部类
		button.setOnClickListener(view -> {
			lastView = view;
			System.out.println("button clicked!");
		});
	}

	private void test2() {
		Button button = new Button();
		View clickView = null;

		// 创建了View.OnClickListener匿名内部类
		button.setOnClickListener(view -> {
			// clickView = view;
			System.out.println("button clicked!");
		});
	}

}
