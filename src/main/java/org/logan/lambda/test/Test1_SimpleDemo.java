package org.logan.lambda.test;

/**
 * desc: Lambda课程 -- 简单例子 <br/>
 * time: 2018/4/18 下午7:04 <br/>
 * author: 居廉 <br/>
 * since V 1.0 <br/>
 */
class Test1_SimpleDemo {

	public static void main(String[] args) {
		testHelloLambda();
	}

	// 第一个Lambda表达式
	private static void testHelloLambda() {
		int x = 3;
		new Thread(() -> {
			System.out.println("Hello Lambda！");
		}).start();
	}

}
