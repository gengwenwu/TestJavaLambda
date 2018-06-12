package org.logan.lambda.chapter3;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.logan.lambda.common.LogUtil.printEmptyLine;

/**
 * desc: 使用stream api重构练习。<br/>
 * 遗留代码:找出长度大于 1 分钟的曲目。<br/>
 * time: 2018/6/11 上午7:52 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_19_Reconstruction_1 {

	public static void main(String[] args) {
		//TODO
		printEmptyLine();
	}


	private static Set<String> findLongTrack(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();

		for (Album album : albums) {
			for (Track track : album.getTrackList()) {
				if (track.getLength() > 60) {
					String name = track.getName();
					trackNames.add(name);
				}
			}
		}

		return trackNames;
	}

//	public static Set<String> test(List<Album> albums) {
//		//TODO
//		Set<String> trackNames = new HashSet<>();
//
//		for (Album album : albums) {
//			for (Track track : album.getTrackList()) {
//				if (track.getLength() > 60) {
//					String name = track.getName();
//					trackNames.add(name);
//				}
//			}
//		}
//
//		// 遗留代码:找出长度大于 1 分钟的曲目
//		return trackNames;
//	}


	// 1：将for替换成forEach
	public static Set<String> findLongTracks1(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream().forEach(album -> {
			album.getTracks()
					.forEach(track -> {
						if (track.getLength() > 60) {
							String name = track.getName();
							trackNames.add(name);
						}
					});
		});
		return trackNames;
	}

	// 2：if 替换成 filter，使用map收集属性
	public static Set<String> findLongTracks2(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
				.forEach(album -> {
					album.getTracks()
							.filter(track -> track.getLength() > 60)
							.map(track -> track.getName())
							.forEach(name -> trackNames.add(name));
				});
		return trackNames;
	}

	// 3：flatMap 重构 子List
	public static Set<String> findLongTracks3(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.forEach(name -> trackNames.add(name));

		return trackNames;
	}

	// 4：collect 重构子Set集合
	public static Set<String> findLongTracks4(List<Album> albums) {
		return albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.collect(Collectors.toSet());
	}

	// 5：使用方法属性
	public static Set<String> findLongTracks5(List<Album> albums) {
		return albums.stream()
				.flatMap(Album::getTracks)
				.filter(track -> track.getLength() > 60)
				.map(Track::getName)
				.collect(Collectors.toSet());
	}

}
