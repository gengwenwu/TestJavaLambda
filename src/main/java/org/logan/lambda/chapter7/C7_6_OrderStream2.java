package org.logan.lambda.chapter7;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Track;

import java.util.function.ToLongFunction;

import static org.logan.lambda.common.SampleData.allAlbums;

/**
 * desc: 优化 C7_6_OrderStream <br/>
 * time: 2020/6/10 11:50 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class C7_6_OrderStream2 {

	// 优化点：抽取公共代码，将业务代码作为参数
	private long countFuture(ToLongFunction<Album> function) {
		return allAlbums.stream()
				.mapToLong(function)
				.sum();
	}

	// 统计所有歌曲播放时长
	public long countRunningTime() {
		return countFuture(album -> album.getTracks()
				.mapToLong(Track::getLength)
				.sum()
		);
	}

	// 统计所有 音乐家数量
	public long countMusicians() {
		return countFuture(album -> album.getMusicianList().size());
	}

	// 统计所有 歌曲数量
	public long countTracks() {
		return countFuture(album -> album.getTrackList().size());
	}


}
