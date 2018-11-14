package org.logan.lambda.chapter5;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: 将流中的数据生成一个特定的值 - 如：字符串，Collectors.joining() <br/>
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_3_Collection5 {

	public static void main(String[] args) {
		// 要求将艺术家姓名格式化为：
		// 	 [周杰伦, 老狼, 四大天王, 张学友, 刘德华, 郭富城, 黎明]
		printArtistNames(SampleData.allArtists);
		printArtistNames(SampleData.allArtists.stream());
	}

	/**
	 * java8之前格式化字符串
	 */
	private static void printArtistNames(List<Artist> artists) {
		StringBuilder builder = new StringBuilder("[");
		for (Artist artist : artists) {
			if (builder.length() > 1) {
				builder.append(", ");
			}

			String name = artist.getName();
			builder.append(name);
		}

		builder.append("]");
		System.out.println("艺术家名称1：" + builder.toString());
	}

	/**
	 * java8 格式化字符串
	 */
	private static void printArtistNames(Stream<Artist> artistStream) {
		String result = artistStream.map(Artist::getName)
				.collect(Collectors.joining(", ", "[", "]"));
		System.out.println("艺术家名称2：" + result);
	}

}
