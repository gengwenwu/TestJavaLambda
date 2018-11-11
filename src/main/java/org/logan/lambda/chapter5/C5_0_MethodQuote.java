package org.logan.lambda.chapter5;


import org.logan.lambda.common.model.Track;

import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.function.IntFunction;

/**
 * desc: lambda - 方法引用 <br/>
 * 1，标准语法为：Classname::methodName，不需要小括号。支持普通函数、构造方法、数组。<br/>
 * 2，凡是使用 Lambda 表达式的地方，就可以使用方法引用 <br/>
 * 3，方法引用自动支持多个参数，前提是选对了正确的函数接口。
 * time: 2018/11/11 上午9:27 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_0_MethodQuote {

	public static void main(String[] args) {
		testMethodQuote();

		// testMethodQuoteConstructor();

		// testMethodQuoteArray();
	}

	/**
	 * 1，测试方法引用 - 普通函数
	 */
	private static void testMethodQuote() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				doSleep();
				System.out.println("do some thing!");
			}
		}).start();
	}

	private static void doSleep() {
		try {
			System.out.println("do Sleep begin...");
			TimeUnit.SECONDS.sleep(1);
			System.out.println("do Sleep end...");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


	/**
	 * 2，测试方法引用 - 构造函数
	 */
	private static void testMethodQuoteConstructor() {
		// 正常歌曲
		Track track = createFinalTrack((musicName, musicLength) -> {
			return new Track(musicName, musicLength);
		}, "光辉岁月", 180);
		System.out.println("开始播放歌曲：" + track.getName() + ", 歌曲长度：" + track.getLength());

		// 异常歌曲
		track = createFinalTrack(Track::new, "北京一夜", 200);
		System.out.println("开始播放歌曲：" + track.getName() + ", 歌曲长度：" + track.getLength());
	}

	private static Track createFinalTrack(BiFunction<String, Integer, Track> function, String name, int length) {
		// 拦截禁播歌曲
		if ("北京一夜".equals(name)) {
			return new Track("沉默是金", 300);
		} else {
			// 歌曲合法
			return function.apply(name, length);
		}
	}


	/**
	 * 3，测试方法引用 - 数组
	 */
	private static void testMethodQuoteArray() {
		IntFunction<int[]> arrayMaker = int[]::new; //String[]::new
		int[] intArray = arrayMaker.apply(10);
		System.out.println("array length:" + intArray.length);
	}

}
