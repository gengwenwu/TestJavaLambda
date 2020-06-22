package org.logan.lambda.chapter8.command;

/**
 * desc: 命令模式 <br/>
 * time: 2020/6/22 4:44 下午 <br/>
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
		Macro macro = new Macro();
		Editor editor = new EditorPrinter();

		macro.record(new Open(editor));
		macro.record(new Save(editor));
		macro.record(new Close(editor));
		macro.run();
	}

	// lambda方式
	private static void runByLambda() {
		Macro macro = new Macro();
		Editor editor = new EditorPrinter();

		macro.record(editor::open); // 可以不用写Open类了
		macro.record(editor::save); // 可以不用写Save类了
		macro.record(editor::close); // 可以不用写Close类了

		macro.run();
	}

}