package org.logan.lambda.chapter1;

import org.logan.lambda.chapter1.model.Album;
import org.logan.lambda.chapter1.model.Artist;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.logan.lambda.LogUtil.printEmptyLine;

/**
 * desc: 练习题测试 <br/>
 * http://www.cnblogs.com/invoker-/p/6904942.html <br/>
 * time: 2018/4/24 下午3:20 <br/>
 * author: 居廉 <br/>
 * since V 1.0 <br/>
 */
class TestExercises {

	public static void main(String[] args) {
		System.out.println("addUp1()->" + addUp1(Stream.of(1, 2, 3, 4)));
		System.out.println("addUp2()->" + addUp2(Stream.of(1, 2, 3, 4)));
		printEmptyLine();

		getArtistNamesAndNations(SampleData.allArtists);
		printEmptyLine();

		getAlbumsWithMostThreeTracks(SampleData.allAlbums);
		printEmptyLine();

		printTotalMembers(SampleData.getThreeArtists());
		printEmptyLine();

		mostLowCaseLetters(Arrays.asList("AbcH", "BBBBB", "aaaaaaa"));
		printEmptyLine();
	}

	/**
	 * 求和
	 */
	public static int addUp1(Stream<Integer> numbers) {
		return numbers.reduce(0, Integer::sum);
	}

	/**
	 * 求和
	 */
	public static int addUp2(Stream<Integer> numbers) {
		return numbers.reduce(0, (acc, element) -> acc + element);
	}

	/**
	 * 编写一个函数，参数为艺术家集合，返回一个字符串集合，其中包含了艺术家的姓名与国籍。
	 */
	public static List<String> getArtistNamesAndNations(List<Artist> allArtists) {
		List<String> messages = allArtists
				.stream()
				.flatMap(artist -> Stream.of(artist.getName(), artist.getNationality()))
				.collect(Collectors.toList());

		messages.forEach(System.out::println);
		return messages;
	}


	// 编写一个函数，参数为专辑集合，返回一个由 最多包含3首歌曲的专辑 组成的集合。
	// (专辑类名为Album，里面包含了一个返回本专辑所有歌曲的集合的方法getTrackList())
	public static List<Album> getAlbumsWithMostThreeTracks(List<Album> albums) {
		List<Album> lists = albums.stream()
				.filter(album -> album.getTracks().count() <= 3)
				.collect(Collectors.toList());

		System.out.println("getAlbumsWithMostThreeTracks() -> ");
		lists.forEach(album ->
				System.out.println("album" + album.getName() + ", size:" + album.getTracks().count())
		);

		return lists;
	}

	/**
	 * 测试内部迭代
	 */
	public static void printTotalMembers(List<Artist> allArtists) {
		/* 将外部迭代转换成内部迭代 */
		int totalMembers = 0;
		for (Artist artist : allArtists) {
			Stream<Artist> members = artist.getMembers();
			totalMembers += members.count();
		}

		// 内部迭代, 注意sum与count区别
		long sum = allArtists.stream()
				.mapToInt(artist -> (int) artist.getMembers().count()) //统计人数,转换成数值流
				.reduce(0, Integer::sum);

		long count = allArtists.stream()
				.mapToInt(artist -> (int) artist.getMembers().count()) //统计人数,转换成数值流
				.count();

		System.out.println("printTotalMembers() -> sum: " + sum + ", count:" + count);
	}

	/**
	 * 在一个字符串集合中，找出包含最多小写字母的字符串。
	 */
	private static void mostLowCaseLetters(List<String> strings) {
		System.out.println("mostLowCaseLetters() -> 集合中，最多小字母字符串是：");
		// 使用比较器
		Optional<String> mostLowCaseLetters1 = strings.stream()
				.max(Comparator.comparing(TestExercises::countStringLowerCaseLetters));
		mostLowCaseLetters1.ifPresent(it -> System.out.println("使用比较器：" + it));

		// 使用数值流
		OptionalLong optionalLong = strings.stream()
				.mapToLong(TestExercises::countStringLowerCaseLetters)
				.max();
		optionalLong.ifPresent(it -> System.out.println("使用数值流：" + it));

		//System.out.println("mostLowcaseLetters() -> mostLowcaseLetters1:"
		//		+ mostLowCaseLetters1.ifPresent(it -> it));
	}

	/**
	 * 统计小写字符串
	 */
	private static long countStringLowerCaseLetters(String message) {
		return message.chars()
				.filter(c -> Character.isLowerCase(c))
				//.filter(Character::isLowerCase)
				.count();
	}

}