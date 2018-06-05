package org.logan.lambda.chapter1;

import org.logan.lambda.common.helper.Button;
import org.logan.lambda.common.helper.View;

/**
 * desc: 匿名内部类将代码作为数据传递。 <br/>
 * time: 2018/5/5 上午11:05 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C1_1_ButtonClick {

	public static void main(String[] args) {
		Button button = new Button();

		button.setOnClickListener(new View.OnClickListener() { // 创建了View.OnClickListener匿名内部类
			@Override
			public void onClick(View view) {
				System.out.println("button clicked!");
			}
		});
	}

}
