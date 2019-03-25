package org.logan.lambda.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.regex.Matcher;
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

	public static void main(String[] args) {
		// TODO: 2019/3/24  
		InputStream enWiki = C6_6_WordCounting.class.getResourceAsStream("enwiki-20131230-stubs-meta-hist-incr.xml");
		new C6_6_WordCounting().countUsers(enWiki);
		// InputStream huckleberryFinn = WordCounting.class.getResourceAsStream("huckleberry_finn");
		// new WordCounting().countWords(huckleberryFinn);
	}

	private static final Pattern username = Pattern.compile("\\s+<username>(.*?)</username>");

	public void countUsers(InputStream stream) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
			Map<String, Long> counts = reader
					.lines()
					.parallel()
					.filter(line -> line.contains("<username>"))
					.map(line -> {
						Matcher matcher = username.matcher(line);
						matcher.find();
						return matcher.group(1);
					})
					.collect(groupingBy(word -> word, counting()));

			counts.forEach((word, count) -> System.out.println(word + " -> " + count));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static final Pattern space = Pattern.compile("\\s+");

	public void countWords(InputStream stream) {
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

}
