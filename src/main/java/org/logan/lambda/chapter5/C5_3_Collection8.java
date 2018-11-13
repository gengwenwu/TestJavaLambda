package org.logan.lambda.chapter5;

import org.logan.lambda.chapter5.helper.StringCombiner;
import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * desc: 对收集器的归一化处理 {@link Collectors#reducing(BinaryOperator)} <br/>
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_3_Collection8 {

	public static void main(String[] args) {
		printArtistNamesByStream(SampleData.allArtists);
	}

	private static void printArtistNamesByStream(List<Artist> artists) {
		/*
		 * Collectors.reducing 收集器，它为流上的归一操作提供了统一实现。
	 	 * 在此例中，这种写法有些糟糕、并且低效。
		 */
		StringCombiner combiner = artists.stream()
				.map(Artist::getName)
				.collect(Collectors.reducing(new StringCombiner(",", "[", "]")
						, name -> new StringCombiner(",", "[", "]").add(name)
						, StringCombiner::merge2)
				);
		System.out.println("result:" + combiner.toString());
	}

}