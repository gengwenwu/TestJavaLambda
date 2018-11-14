package org.logan.lambda.chapter5;

import org.logan.lambda.chapter5.helper.StringCollector;
import org.logan.lambda.chapter5.helper.StringCombiner;
import org.logan.lambda.common.LogUtil;
import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.List;

/**
 * desc: 重构和定制收集器 <br/>
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_3_Collection7 {

	public static void main(String[] args) {
		// 要求将艺术家姓名格式化为：
		//    [周杰伦, 老狼, 四大天王, 张学友, 刘德华, 郭富城, 黎明]

		// java7 方式
		C5_3_Collection5.printArtistNames(SampleData.allArtists);
		LogUtil.printEmptyLine();

		// 使用stream改进 1
		printArtistNamesByStream1(SampleData.allArtists);
		LogUtil.printEmptyLine();

		// 使用reduce改进 2
		printArtistNamesByStream2(SampleData.allArtists);
		LogUtil.printEmptyLine();

		// 优化reduce 3
		printArtistNamesByStream3(SampleData.allArtists);
		LogUtil.printEmptyLine();

		// 使用自定义收集器 4
		printArtistNamesByStream4(SampleData.allArtists);

	}

	private static void printArtistNamesByStream1(List<Artist> artists) {
		StringBuilder builder = new StringBuilder("[");
		/* 代码看起来更清楚一点，可以 forEach 方法看起来还是有点笨重 */
		artists.stream()
				.map(Artist::getName)
				.forEach(artistName -> {
					if (builder.length() > 1) {
						builder.append(",");
					}

					builder.append(artistName);
				});

		builder.append("]");
		System.out.println("艺术家1：" + builder.toString());
	}

	private static void printArtistNamesByStream2(List<Artist> artists) {
		/* 如果使用reduce对进行操作，代码更糟糕，不忍直视！ */
		StringBuilder reducedSb = artists.stream()
				.map(Artist::getName)
				.reduce(new StringBuilder()
						, (builder, artistName) -> {
							if (builder.length() > 0) {
								builder.append(",");
							}

							builder.append(artistName);
							return builder;
						}
						, (left, right) -> null  //left.append(right) ??
				);

		reducedSb.insert(0, "[").append("]");
		System.out.println("艺术家2：" + reducedSb.toString());
	}

	private static void printArtistNamesByStream3(List<Artist> artists) {
		/* 优化reduce - 使用StringCombiner */
		StringCombiner combined = artists.stream()
				.map(Artist::getName)
				.reduce(new StringCombiner(",", "[", "]")
						, StringCombiner::add
						, StringCombiner::merge
				);
		System.out.println("艺术家3:" + combined.toString());
	}

	private static void printArtistNamesByStream4(List<Artist> artists) {
		/* 使用自定义收集器 */
		String result = artists.stream()
				.map(Artist::getName)
				.collect(new StringCollector(",", "[", "]"));
		System.out.println("艺术家4:" + result);
	}

}
