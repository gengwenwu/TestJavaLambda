package org.logan.lambda.chapter1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * desc: 专辑 <br/>
 * time: 2018/4/19 上午11:56 <br/>
 * author: 居廉 <br/>
 * since V TODO <br/>
 */
public final class Album implements Performance {

	private String name;
	private List<Track> tracks;
	private List<Artist> musicians;

	public Album(String name, List<Track> tracks, List<Artist> musicians) {
		this.name = name;
		this.tracks = new ArrayList<>(tracks);
		this.musicians = new ArrayList<>(musicians);
	}


	public String getName() {
		return name;
	}

	public Stream<Track> getTracks() {
		return tracks.stream();
	}

	public List<Track> getTrackList() {
		return Collections.unmodifiableList(tracks);
	}

	public Stream<Artist> getMusicians() {
		return musicians.stream();
	}

	public List<Artist> getMusicianList() {
		return Collections.unmodifiableList(musicians);
	}

	public Artist getMainMusician() {
		return musicians.get(0);
	}

	public Album copy() {
		List<Track> tracks = getTracks().map(Track::copy).collect(java.util.stream.Collectors.toList());
		List<Artist> musicians = getMusicians().map(Artist::copy).collect(java.util.stream.Collectors.toList());
		return new Album(name, tracks, musicians);
	}

}
