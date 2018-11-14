package org.logan.lambda.chapter5;

import org.logan.lambda.common.LogUtil;
import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: 组合收集器 <br/>
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_3_Collection6 {

	public static void main(String[] args) {
		{
			numberOfAlbums1(SampleData.allAlbums.stream());
			LogUtil.printEmptyLine();

			numberOfAlbums2(SampleData.allAlbums.stream());
			LogUtil.printEmptyLine();
		}

		{
			nameOfAlbumsDumb1(SampleData.allAlbums.stream());
			LogUtil.printEmptyLine();

			nameOfAlbums(SampleData.allAlbums.stream());
			LogUtil.printEmptyLine();
		}

	}

	/**
	 * 计算每个艺术家专辑数 -- 方式一：先对艺术家先分组，然后计数。<br/>
	 * 缺陷：是命令式的代码，不能自动适应并行化操作。
	 */
	private static void numberOfAlbums1(Stream<Album> albums) {
		Map<Artist, List<Album>> albumsMap = albums
				.collect(Collectors.groupingBy(Album::getMainMusician));
		Map<Artist, Integer> numbersOfAlbums = new HashMap<>();

		for (Artist artist : albumsMap.keySet()) {
			numbersOfAlbums.put(artist, albumsMap.get(artist).size());
//			System.out.println("艺术家：" + artist.getName());
//			albumsMap.get(artist)
//					.stream()
//					.flatMap(album -> album.getTrackList().stream())
//					.forEach(track -> System.out.println("   " + track.getName()));
		}

		numbersOfAlbums.forEach((artist, count) ->
				System.out.println("艺术家：" + artist.getName() + ", 专辑数：" + count)
		);
	}

	/**
	 * 计算每个艺术家专辑数 -- 方式二：使用{@link Collectors#counting()}。<br/>
	 */
	private static void numberOfAlbums2(Stream<Album> albums) {
		/*
		 * groupingBy 先将元素分成块，每块都与分类函数 getMainMusician 提供的键值相关联，
		 * 然后使用下游的另一个收集器收集每块中的元素，
		 * 最后将结果映射为一个 Map。
		 **/
		Map<Artist, Long> albumsMap = albums
				.collect(Collectors.groupingBy(Album::getMainMusician, Collectors.counting()));

		albumsMap.forEach((artist, count) ->
				System.out.println("艺术家：" + artist.getName() + ", 专辑数：" + count)
		);
	}


	/**
	 * 让我们再看下面的例子，这次我们不想生成一组专辑，只希望得到专辑名。<br/>
	 * 统计艺术家专辑名称列表 -- 对 {@link #numberOfAlbums1(Stream)} 简单改版方式。<br/>
	 */
	private static void nameOfAlbumsDumb1(Stream<Album> albums) {
		Map<Artist, List<Album>> albumsByArtist = albums
				.collect(Collectors.groupingBy(Album::getMainMusician));

		// 与方式一区别：希望得到是专辑名称列表，即：Map的value值是List<String>，如下：
		Map<Artist, List<String>> nameOfAlbums = new HashMap<>();

		for (Artist artist : albumsByArtist.keySet()) {
			nameOfAlbums.put(artist
					, albumsByArtist.get(artist).stream()
							.map(Album::getName)
							.collect(Collectors.toList())
			);
		}

		nameOfAlbums.forEach((artist, albumNameList)
				-> System.out.println("艺术家：" + artist.getName() + ", 专辑数：" + albumNameList.size())
		);
	}

	/**
	 * 统计艺术家专辑名称列表 -- 改进 {@link #nameOfAlbumsDumb1(Stream)} 方式
	 */
	private static void nameOfAlbums(Stream<Album> albums) {
		Map<Artist, List<String>> nameOfAlbums = albums
				.collect(Collectors.groupingBy(Album::getMainMusician
						// mapping 允许在收集器的容器上执行类似 map 的操作
						, Collectors.mapping(Album::getName, Collectors.toList())));

		nameOfAlbums.forEach((artist, albumNameList)
				-> System.out.println("艺术家：" + artist.getName() + ", 专辑数：" + albumNameList.size())
		);

	}


}
