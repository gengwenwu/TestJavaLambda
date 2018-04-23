package org.logan.lambda.chapter1.model;

/**
 * desc: 音轨 <br/>
 * time: 2018/4/19 上午11:49 <br/>
 * author: 居廉 <br/>
 * since V TODO <br/>
 */
public final class Track {

	private final String name;
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
