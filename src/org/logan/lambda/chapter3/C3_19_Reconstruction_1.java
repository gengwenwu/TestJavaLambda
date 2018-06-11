package org.logan.lambda.chapter3;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Track;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * desc: 使用stream api练习 TODO <br/>
 * time: 2018/6/11 上午7:52 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_19_Reconstruction_1 {

	// 遗留代码:找出长度大于 1 分钟的曲目
	public Set<String> findLongTracks(List<Album> albums) {
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


	public Set<String> findLongTracks2(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
				.forEach(album -> {
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


	public Set<String> findLongTracks3(List<Album> albums) {
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


	public Set<String> findLongTracks4(List<Album> albums) {
		Set<String> trackNames = new HashSet<>();
		albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.forEach(name -> trackNames.add(name));

		return trackNames;
	}

	public Set<String> findLongTracks5(List<Album> albums) {
		return albums.stream()
				.flatMap(album -> album.getTracks())
				.filter(track -> track.getLength() > 60)
				.map(track -> track.getName())
				.collect(Collectors.toSet());
	}

	public Set<String> findLongTracks6(List<Album> albums) {
		return albums.stream()
				.flatMap(Album::getTracks)
				.filter(track -> track.getLength() > 60)
				.map(Track::getName)
				.collect(Collectors.toSet());
	}

}
