package org.logan.lambda.chapter7;

import org.logan.lambda.common.helper.Logger;

import static org.logan.lambda.chapter4.C4_1_UseLambda.expensiveOperation;

/**
 * desc: Logger中使用Lambda <br/>
 * time: 2020/6/9 5:49 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C7_1_LoggerLambdaExpression {

	public static void main(String[] args) {
		// bad code （反模式）
		Logger logger = new Logger();
		if (logger.isDebugEnabled()) {
			logger.debug("Look at this " + expensiveOperation());
		}

		// 使用 Lambda 优化之后
		Logger logger2 = new Logger(false);
		logger2.debug(() -> "Look at this " + expensiveOperation()); // 细节隐藏到了内部

	}
}
