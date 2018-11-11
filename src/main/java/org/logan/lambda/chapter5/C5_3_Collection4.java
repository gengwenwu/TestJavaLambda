package org.logan.lambda.chapter5;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: 数据分组 groupingBy <br/>
 * {@link Collectors#groupingBy(Function)} <br/>
 * {@link Collectors#groupingByConcurrent(Function)} <br/>
 * {@link Collectors#groupingBy(Function, Collector)} <br/>
 * 等等
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_3_Collection4 {

	public static void main(String[] args) {
		albumsByArtist(SampleData.allAlbums.stream());
	}

	/**
	 * 使用 Collectors.groupingBy() 对专辑分组
	 */
	private static void albumsByArtist(Stream<Album> albums) {
		/* 主唱对专辑分组 */
		Map<Artist, List<Album>> albumsByArtist = albums.collect(Collectors.groupingBy(Album::getMainMusician));

		albumsByArtist.forEach((artist, albumList) -> {
			System.out.println("歌手名称：" + artist.getName());

			albumList.forEach(
					album -> System.out.println("	专辑名称：" + album.getName())
			);
		});
	}


}
