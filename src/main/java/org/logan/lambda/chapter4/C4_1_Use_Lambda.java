package org.logan.lambda.chapter4;

import org.logan.lambda.common.helper.Logger;

import java.util.concurrent.TimeUnit;

/**
 * desc: 使用Lambda，简化写法、改进程序性能 - logger例子<br/>
 * time: 2018/7/31 上午7:31 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C4_1_Use_Lambda {

	private static Logger mLogger;


	public static void main(String[] args) {
		mLogger = new Logger(true);
		long time = System.currentTimeMillis();

		printlnLog1();
		printlnLog2();
		printlnLogUseLambda();

		System.out.println("use Time:" + (System.currentTimeMillis() - time));
	}

	private static void printlnLog1() {
		mLogger.debug("Look at this:" + expensiveOperation());
	}

	private static void printlnLog2() {
		if (mLogger.isDebugEnabled()) {
			mLogger.debug("Look at this:" + expensiveOperation());
		}
	}

	private static void printlnLogUseLambda() {
		mLogger.debug(() -> "Look at this:" + expensiveOperation());
	}

	private static String expensiveOperation() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "expensive operation";
	}

}
