package org.logan.lambda.chapter7;

import org.logan.lambda.common.model.Track;

import static org.logan.lambda.common.SampleData.allAlbums;

/**
 * desc: 优化 C7_5_Order，使用 Stream 实现相关统计 <br/>
 * time: 2020/6/10 11:50 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

class C7_6_OrderStream {

	// 统计所有歌曲播放时长
	public long countRunningTime() {
		return allAlbums.stream()
				.mapToLong(album -> album.getTracks()
						.mapToLong(Track::getLength)
						.sum()
				).sum();
	}

	// 统计所有 音乐家数量
	public long countMusicians() {
		return allAlbums.stream()
				.mapToLong(album -> album.getMusicianList().size())
				.sum();
	}

	// 统计所有 歌曲数量
	public long countTracks() {
		return allAlbums.stream()
				.mapToLong(album -> album.getTrackList().size())
				.sum();
	}

}
