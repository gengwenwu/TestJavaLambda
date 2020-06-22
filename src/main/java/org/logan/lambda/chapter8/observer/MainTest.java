package org.logan.lambda.chapter8.observer;

/**
 * desc: 观察者测试类 <br/>
 * time: 2020/6/22 6:03 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class MainTest {

	public static void main(String[] args) {
		runByJavaNormal();
		runByLambda();
	}

	// java 普通方式
	private static void runByJavaNormal() {
		Moon moon = new Moon();
		moon.startSpying(new Nasa());
		moon.startSpying(new Aliens());

		moon.land("An asteroid.");
		moon.land("Apollo 11");

	}

	// lambda 方式
	private static void runByLambda() {
		Moon moon = new Moon();

		// nasa
		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println("We made it!");
			}
		});

		// Aliens
		moon.startSpying(name -> {
			if (name.contains("Apollo")) {
				System.out.println("They're distracted, lets invade earth!");
			}
		});

		moon.land("An asteroid.");
		moon.land("Apollo 11");
	}

}