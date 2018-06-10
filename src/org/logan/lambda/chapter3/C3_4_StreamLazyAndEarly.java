package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;

/**
 * desc: 惰性求值、及早求值 <br/>
 * time: 2018/6/10 下午5:12 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_4_StreamLazyAndEarly {

	public static void main(String[] args) {

		String nationality = "中国香港";
		// 惰性求值
		// 这行代码并未做什么实际性的工作，filter 只刻画出了 Stream，但没有产生新的集合。
		// 像 filter 这样只描述 Stream，最终不产生新集合的方法叫作惰性求值方法；
		SampleData.allArtists.stream()
				.filter(artist -> {
					System.out.println(artist.getName());
					return artist.isFrom(nationality);
				});

		// 及早求值
		System.out.println("===============");
		long count = SampleData.allArtists.stream()
				.filter(artist -> {
					System.out.println(artist.getName());
					return artist.isFrom(nationality);
				}).count();
		System.out.println(nationality + "'音乐家个数：" + count);
	}

}
