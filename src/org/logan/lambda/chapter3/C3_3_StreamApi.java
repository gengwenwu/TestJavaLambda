package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;

/**
 * desc: 内部迭代Stream <br/>
 * time: 2018/6/10 下午5:00 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_3_StreamApi {

	public static void main(String[] args) {
		String nationality = "中国香港";

		long count = SampleData.allArtists.stream()
				.filter(artist -> artist.isFrom(nationality))
				.count();

		System.out.println(nationality + "'音乐家个数：" + count);
	}

}
