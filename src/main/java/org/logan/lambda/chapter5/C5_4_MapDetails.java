package org.logan.lambda.chapter5;

import org.logan.lambda.common.LogUtil;
import org.logan.lambda.common.model.Artist;

import java.util.HashMap;
import java.util.Map;

/**
 * desc: Map一些细节 <br/>
 * time: 2018/11/11 下午17:11 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C5_4_MapDetails {

	private static final String ARTIST_NAME = "陈奕迅";
	private static Map<String, Artist> mArtistCache;


	public static void main(String[] args) {
		mArtistCache = new HashMap<>(3);

		/* 传统 Map缓存机制 */
		getArtist1(ARTIST_NAME);
		LogUtil.printEmptyLine();
		getArtist1(ARTIST_NAME);


		/* Java8 Map缓存机制 */
		// getArtist2(ARTIST_NAME);
		// LogUtil.printEmptyLine();
		// getArtist2(ARTIST_NAME);

		// java8 循环方式
		doMapForInJava8();
	}


	/**
	 * 实现一个缓存 - 传统的处理方式 <br/>
	 * 思路：优先缓存数据使用，如果没有，从DB中去，再放入缓存中。
	 */
	private static Artist getArtist1(String name) {
		Artist artist = mArtistCache.get(name);

		if (artist == null) {
			artist = readArtistFromDB(name);
			mArtistCache.put(name, artist);
		} else {
			System.out.println("从缓存读取：" + name);
		}

		return artist;
	}

	private static Artist readArtistFromDB(String name) {
		if (ARTIST_NAME.equals(name)) {
			System.out.println("从DB读取：" + name);
			return new Artist(ARTIST_NAME, "中国香港");
		} else {
			try {
				throw new Exception("只支持" + ARTIST_NAME + "！");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}

	/**
	 * 实现一个缓存 - Java8处理方式 <br/>
	 */
	private static Artist getArtist2(String name) {
		// computeIfAbsent()，接受一个Lambda表达式，值不存在时使用该 Lambda 表达式计算新值 。
		Artist artist = mArtistCache.computeIfAbsent(name, C5_4_MapDetails::readArtistFromDB);

		System.out.println("读取到了：" + artist.getName());
		return artist;
	}

	/**
	 * Java8 Map循环
	 */
	private static void doMapForInJava8() {
		LogUtil.printEmptyLine();

		mArtistCache.forEach((key, value) ->
				System.out.println(value.getName() + ", " + value.getNationality())
		);
	}

}
