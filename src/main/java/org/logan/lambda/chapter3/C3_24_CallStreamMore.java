package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * desc: 多次调用Stream <br/>
 * time: 2018/6/11 上午7:58 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_24_CallStreamMore {

	/**
	 * 误用 Stream 的例子：多次调用stream。
	 * {@link C3_18_Test}例子才是正确方式。
	 */
	public static void main(String[] args) {

		List<Artist> musicians = SampleData.wenBie.getMusicians()
				.collect(Collectors.toList());

		List<Artist> bands = musicians.stream()
				.filter(artist -> artist.getName().startsWith("The"))
				.collect(Collectors.toList());

		Set<String> origins = bands.stream()
				.map(artist -> artist.getNationality())
				.collect(Collectors.toSet());

	}

}
