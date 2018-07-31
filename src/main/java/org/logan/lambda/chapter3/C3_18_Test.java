package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * desc: 整合Stream api 练习<br/>
 * time: 2018/6/11 上午7:37 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_18_Test {

	public static void main(String[] args) {
		// TODO
		// 找出 SampleData.rollingStonesYears 专辑上的所有表演者。
		// 分辨出哪些表演者姓名超过2个字。
		// 并找出每个乐队的籍贯。
		// 最后将找出的籍贯放入一个集合返回。

	}

	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//
	//

	private static List<String> getArtistNationalities() {
		List<String> nationalities = new ArrayList<>();

		for (Artist artist : SampleData.rollingStonesYears.getMusicianList()) {
			if (artist.getName().length() > 2) {
				nationalities.add(artist.getNationality());
			}
		}

		return nationalities;
	}

	private static void getArtistNationalitiesByLambda() {
		List<String> list = SampleData.rollingStonesYears.getMusicianList()
				.stream()
				.filter(artist -> artist.getName().length() > 2)
				.map(artist -> artist.getNationality())
				.collect(Collectors.toList());

		list.forEach(System.out::println);
	}

}
