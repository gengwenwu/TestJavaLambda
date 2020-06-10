package org.logan.lambda.chapter7;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Track;

import static org.logan.lambda.common.SampleData.allAlbums;

/**
 * desc: 使用命令式 Java 实现相关统计 <br/>
 * time: 2020/6/10 11:44 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C7_5_Order {

	// 统计所有歌曲播放时长
	public long countRunningTime() {
		int count = 0;
		for (Album album : allAlbums) {
			for (Track track : album.getTrackList()) {
				count += track.getLength();
			}
		}

		return count;
	}

	// 统计所有 音乐家数量
	public long countMusicians() {
		long count = 0;
		for (Album album : allAlbums) {
			count += album.getMusicianList().size();
		}
		return count;
	}

	// 统计所有 歌曲数量
	public long countTracks() {
		long count = 0;
		for (Album album : allAlbums) {
			count += album.getTrackList().size();
		}
		return count;
	}

}