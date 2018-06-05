package org.logan.lambda.chapter1;

import org.logan.lambda.common.helper.Button;

/**
 * desc: 使用 Lambda 表达式将行为和按钮单击进行关联。 <br/>
 * time: 2018/5/5 上午11:05 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C1_2_ButtonClickLambda {

	public static void main(String[] args) {
		Button button = new Button();
		button.setOnClickListener(v -> System.out.println("button clicked!"));
	}

}
