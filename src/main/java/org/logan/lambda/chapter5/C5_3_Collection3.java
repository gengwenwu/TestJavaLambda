package org.logan.lambda.chapter5;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: {@link Collectors#partitioningBy(Predicate)} 将流分解成两个集合 <br/>
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_3_Collection3 {

	public static void main(String[] args) {
		bandsAndSolo(SampleData.allArtists.stream());
	}

	/**
	 * 使用 {@link Collectors#partitioningBy(Predicate)}将流分为两个集合
	 */
	private static void bandsAndSolo(Stream<Artist> artists) {
		/* 将艺术家组成的流分成乐队和独唱歌手两部分 */
		Map<Boolean, List<Artist>> bandsAndSolo = artists.collect(Collectors.partitioningBy(Artist::isSolo));

		bandsAndSolo.forEach((isSolo, artistList) -> {
			System.out.println(isSolo ? "Solo歌手名单:" : "乐队名单: ");

			// 找出歌手
			Stream<Artist> artistStream = isSolo
					? artistList.stream()
					: artistList.stream().flatMap(Artist::getMembers);

			// 打印
			artistStream.forEach(
					artist -> System.out.println("   " + artist.getName())
			);

		});

	}


}
