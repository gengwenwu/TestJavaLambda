package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.Iterator;

/**
 * desc: 外部迭代：Iterator <br/>
 * time: 2018/6/10 下午4:53 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_2_Iterator {

	public static void main(String[] args) {

		int count = 0;
		Iterator<Artist> iterator = SampleData.allArtists.iterator();

		while (iterator.hasNext()) {
			Artist artist = iterator.next();
			if (artist.isFrom("中国香港")) {
				count++;
			}
		}

		System.out.println("count:" + count);
	}

}
