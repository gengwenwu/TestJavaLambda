package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;

import java.util.Set;
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
		// 分辨出哪些表演者是乐队。
		// 找出每个乐队的国籍。
		// 将找出的国籍放入一个集合。

		Set<String> origins = SampleData.wenBie.getMusicians()
				.filter(artist -> artist.getName().contains("一"))
				.map(artist -> artist.getNationality())
				.collect(Collectors.toSet());

	}

}
