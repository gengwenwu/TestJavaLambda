package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;

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
		//TODO
		// 找出专辑上的所有表演者。
		// 分辨出哪些表演者名字超过2个字。
		// 找出每个乐队的籍贯。
		// 将找出的籍贯放入一个集合。

		// SampleData.rollingStonesYears
	}



















	private static void showAnswer() {
		List<String> list = SampleData.rollingStonesYears.getMusicianList()
				.stream()
				.filter(artist -> artist.getName().length() > 2)
				.map(artist -> artist.getNationality())
				.collect(Collectors.toList());

		list.forEach(System.out::println);
	}

}
