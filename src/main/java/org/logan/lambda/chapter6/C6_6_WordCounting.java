package org.logan.lambda.chapter6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * desc: 并行化测试 - 计算文件数量 <br/>
 * time: 2019/3/23 下午9:57 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C6_6_WordCounting {

	// 匹配空格
	private static final Pattern space = Pattern.compile("\\s+");

	public static void main(String[] args) throws FileNotFoundException {
		// 23MB文件
		String path = System.getProperty("user.dir") + "/resources/log2.txt";
		System.err.println("====== begin.... ");

		// 串行化
		long time = System.currentTimeMillis();
		countWordsSerial(new FileInputStream(new File(path)));
		// System.err.println("=================> Serial use time:" + (System.currentTimeMillis() - time));

		// 并行化
		time = System.currentTimeMillis();
		countWordsParallel(new FileInputStream(new File(path)));
		// System.err.println("=================> Parallel use time:" + (System.currentTimeMillis() - time));
	}

	private static void countWordsSerial(InputStream stream) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
			Map<String, Long> counts = reader
					.lines()
					.flatMap(space::splitAsStream)
					.map(String::trim)
					.filter(word -> !word.isEmpty())
					.collect(groupingBy(word -> word, counting()));

			counts.forEach((word, count) -> System.out.println(word + " -> " + count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void countWordsParallel(InputStream stream) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
			Map<String, Long> counts = reader
					.lines()
					.parallel() // 并行化
					.flatMap(space::splitAsStream)
					.map(String::trim)
					.filter(word -> !word.isEmpty())
					.collect(groupingBy(word -> word, counting()));

			counts.forEach((word, count) -> System.out.println(word + " -> " + count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
