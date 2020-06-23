package org.logan.lambda.chapter8.lambdabehave;

import org.logan.lambda.chapter8.lambdabehave.example.StackSpec;

/**
 * desc: 执行 dsl 案例 <br/>
 * time: 2020/6/23 5:22 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class MainTest {

	// 这里执行
	public static void main(String[] args) {
		Runner.current.run(StackSpec.class);
		Runner.current.printReport();
	}

}