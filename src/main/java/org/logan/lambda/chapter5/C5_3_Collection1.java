package org.logan.lambda.chapter5;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * desc: 流转换为集合 <br/>
 * time: 2018/11/11 下午3:13 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class C5_3_Collection1 {

	public static void main(String[] args) {
		doStreamToCollection();
	}

	/**
	 * 流转换成集合
	 */
	private static void doStreamToCollection() {
		// List<Artist> artists = new ArrayList<>();

		/* 流转换成集合 -> 使用Collectors提供的toXXX()方式 */
		{
			Set<String> musicNameSet = SampleData.allArtists.stream()
					.map(Artist::getName)
					.collect(Collectors.toSet()); // 使用JDK提供的
			printLog(musicNameSet);
		}

		/* 流转换成集合 -> 使用指定的集合类 */
		{
			TreeSet<String> musicNameSet = SampleData.allArtists.stream()
					.map(Artist::getName)
					.collect(Collectors.toCollection(TreeSet::new)); // 指定集合类
			printLog(musicNameSet);
		}

	}

	private static void printLog(Collection<String> musicCollection) {
		musicCollection.forEach(musicName -> System.out.print(musicName + ", "));
		System.out.println("");
	}

}
