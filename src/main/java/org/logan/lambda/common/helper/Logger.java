package org.logan.lambda.common.helper;

import java.util.function.Supplier;

/**
 * desc: 模拟Log4j <br/>
 * time: 2018/7/31 上午11:41 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class Logger {

	/**
	 * 是否开启日志
	 */
	private boolean isDebug;


	public Logger(boolean isDebug) {
		this.isDebug = isDebug;
	}


	public boolean isDebugEnabled() {
		return isDebug;
	}

	public void debug(String message) {
		System.out.println(message);
	}

	/**
	 * 使用Lambda表达式输出log
	 */
	public void debug(Supplier<String> supplier) {
		if (isDebugEnabled()) {
			debug(supplier.get());
		}
	}

}