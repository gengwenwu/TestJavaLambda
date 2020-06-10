package org.logan.lambda.chapter7;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.logan.lambda.common.SampleData.rollingStonesYears;

/**
 * desc: 日志和打印消息 <br/>
 * time: 2020/6/10 3:40 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class C7_16_PrintLog {

	public static void main(String[] args) {
		printLogUsingLambdaByPeek(rollingStonesYears);
	}

	// 未使用Lambda代码
	private static Set<String> printLog(Album album) {
		Set<String> nationalities = new HashSet<>();

		for (Artist artist : album.getMusicianList()) {
			if (artist.getName().startsWith("任")) {
				String nationality = artist.getNationality();
				System.out.println("Found nationality: " + nationality);
				nationalities.add(nationality);
			}
		}

		return nationalities;
	}

	// 使用lambda代码
	private static Set<String> printLogUsingLambda(Album album) {
		// 实现上面printLog()逻辑
		Set<String> nationalities
				= album.getMusicians()
				.filter(artist -> artist.getName().startsWith("任"))
				.map(Artist::getNationality)
				.collect(Collectors.toSet());

		// 复制上面的逻辑代码，打印日志，代码有点猥琐。
		album.getMusicians()
				.filter(artist -> artist.getName().startsWith("任"))
				.map(Artist::getNationality)
				.forEach(nationality -> System.out.println("Found: " + nationality));

		return nationalities;
	}

	// 使用lambda + peek()
	private static Set<String> printLogUsingLambdaByPeek(Album album) {
		return album.getMusicians()
				.filter(artist -> artist.getName().startsWith("任"))
				.map(Artist::getNationality)
				// 查看每个值，同时能继续操作流
				.peek(nation -> System.out.println("Found: " + nation))
				.collect(Collectors.toSet());
	}

}
