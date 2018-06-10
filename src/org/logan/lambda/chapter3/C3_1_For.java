package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

/**
 * Java for循环是一种语法糖，原理同样是Iterator。 <br/>
 * 它无法流畅传达程序员的意图，特别是嵌套循环。 <br/>
 * time: 2018/6/10 下午4:43 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_1_For {
	public static void main(String[] args) {
		String nationality = "中国香港";
		int count = 0;
		for (Artist artist : SampleData.allArtists) {
			if (artist.isFrom(nationality)) {
				count++;
			}
		}

		System.out.println(nationality + "'音乐家个数：" + count);
	}
}
