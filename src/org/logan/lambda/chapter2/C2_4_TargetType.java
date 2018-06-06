package org.logan.lambda.chapter2;

/**
 * desc: 目标类型 <br/>
 * time: 2018/5/6 上午10:45 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C2_4_TargetType {

	public static void main(String[] args) {
		// 目标类型在java8之前就出现了
		// 等号右边的代码并没有声明类型，系统根据上下文推断出类型信
		final String[] array = {"hello", "world"};
		String str = null;
	}

}
