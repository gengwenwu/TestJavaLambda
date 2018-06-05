package org.logan.lambda.common.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * desc: 音乐家或乐队  <br/>
 * time: 2018/4/19 上午11:53 <br/>
 * author: 居廉 <br/>
 * since V 1.0 <br/>
 */
public final class Artist {

	/**
	 * 音乐家名称
	 */
	private String name;
	/**
	 * 乐队成员
	 */
	private List<Artist> members;
	/**
	 * 所属国籍、籍贯
	 */
	private String nationality;

	public Artist(String name, String nationality) {
		this(name, Collections.emptyList(), nationality);
	}

	public Artist(String name, List<Artist> members, String nationality) {
		this.name = name;
		this.members = new ArrayList<>(members);
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public Stream<Artist> getMembers() {
		return members.stream();
	}

	public String getNationality() {
		return nationality;
	}

	public boolean isSolo() {
		return members.isEmpty();
	}

	public boolean isFrom(String nationality) {
		return this.nationality.equals(nationality);
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Artist)) {
			return false;
		}

		Artist artist = (Artist) obj;
		return artist.name.equals(this.name)
				&& artist.nationality.equals(this.nationality);
	}

	@Override
	public int hashCode() {
		int n = 31;
		n = n * 31 + this.name.hashCode();
		n = n * 31 + this.nationality.hashCode();
		return n;
	}

	public Artist copy() {
		List<Artist> members = getMembers().map(Artist::copy).collect(Collectors.toList());
		return new Artist(name, members, nationality);
	}

}