package org.logan.lambda.chapter4.c4_19_multi_implements;

/**
 * desc: 测试程序 <br/>
 * time: 2018/8/29 下午5:37 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class TestMain {
	public static void main(String[] args) {
		Carriage box = new MusicalCarriage();
		System.out.println(box.rock());
	}
}
