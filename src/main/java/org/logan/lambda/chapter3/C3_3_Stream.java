package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;

/**
 * desc: 内部迭代：Stream流编程 <br/>
 * time: 2018/6/10 下午5:00 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_3_Stream {

	public static void main(String[] args) {
		long count = SampleData.allArtists.stream()
				.filter(artist -> artist.isFrom("中国香港"))
				.count();

		System.out.println("count:" + count);
	}

}
