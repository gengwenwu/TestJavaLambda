package org.logan.lambda.common.helper;

/**
 * desc: 模拟 android.widget.Button <br/>
 * time: 2018/5/5 上午11:03 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class Button extends View {

	public void setOnClickListener(OnClickListener clickListener) {
		// 简单实现
		clickListener.onClick(this);
	}

}
