package org.logan.lambda.common.model;

/**
 * desc: 歌曲 <br/>
 * time: 2018/4/19 上午11:49 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public final class Track {

	/**
	 * 专辑歌曲
	 */
	private final String name;
	/**
	 * 歌曲播放时间。
	 */
	private final int length;

	public Track(String name, int length) {
		this.name = name;
		this.length = length;
	}

	public String getName() {
		return name;
	}

	public int getLength() {
		return length;
	}

	public Track copy() {
		return new Track(name, length);
	}

}
