package org.logan.lambda.common.model;

/**
 * desc: 模拟 android.view.View <br/>
 * time: 2018/4/18 下午7:08 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class View {

	/**
	 * Interface definition for a callback to be invoked when a view is clicked.
	 */
	public interface OnClickListener {
		/**
		 * Called when a view has been clicked.
		 *
		 * @param v The view that was clicked.
		 */
		void onClick(View v);
	}

}
