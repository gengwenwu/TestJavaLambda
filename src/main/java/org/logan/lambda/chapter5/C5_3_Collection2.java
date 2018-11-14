package org.logan.lambda.chapter5;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: collect收集器 -- 生成一个值 <br/>
 * time: 2018/11/11 下午3:13 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_3_Collection2 {

	public static void main(String[] args) {
		biggestGroup(SampleData.allArtists.stream());

		averageNumberOfTracks(SampleData.allAlbums);
	}

	/**
	 * 利用收集器让流生成一个值。<br/>
	 * Collectors.maxBy 和 Collectors.minBy 允许用户按某种特定的顺序生成一个值。<br/>
	 */
	private static void biggestGroup(Stream<Artist> artists) {
		/* 找出成员最多的乐队 */
		Function<Artist, Long> countFunc = artist -> artist.getMembers().count();
		Optional<Artist> biggestGroup = artists
				.collect(Collectors.maxBy(Comparator.comparing(countFunc)));
		// 简写
		// Optional<Artist> biggestGroup = artists.max(Comparator.comparing(countFunc));

		biggestGroup.ifPresent(artist ->
				System.out.println("乐队最多成员是：" + artist.getName())
		);
	}

	/**
	 * 部分收集器实现了一些常用的数值运算，譬如：
	 * {@link Collectors#averagingDouble(ToDoubleFunction)} <br/>
	 * {@link Collectors#summarizingLong(ToLongFunction)} 等等
	 * int、long、double完美支持。
	 */
	private static void averageNumberOfTracks(List<Album> albums) {
		/* 找出一组专辑上曲目的平均数 */
		{
			// 实现方式一
			double average = albums.stream()
					.collect(Collectors.averagingDouble(album -> album.getTrackList().size()));
			System.out.println("average1:" + average);
		}

		{
			// 下面代码与上面代码等效
			double trackCount = albums
					.stream()
					.mapToInt(album -> album.getTrackList().size())
					.reduce(0, (acc, element) -> acc + element);
			System.out.println("average2:" + (trackCount / albums.size()));
		}

		{
			// 实现方式二 - summarizingInt
			IntSummaryStatistics summary = albums.stream()
					.collect(Collectors.summarizingInt(album -> album.getTrackList().size()));
			System.out.println("average3:" + summary.getAverage() + "，track sum:" + summary.getSum());
		}

	}

}
