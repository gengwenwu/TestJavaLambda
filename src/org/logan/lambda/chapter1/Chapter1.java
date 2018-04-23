package org.logan.lambda.chapter1;

import org.logan.lambda.chapter1.model.Artist;

import java.util.List;
import java.util.stream.Collectors;

/**
 * desc: TODO <br/>
 * time: 2018/4/19 下午2:18 <br/>
 * author: 居廉 <br/>
 * since V TODO <br/>
 */
public class Chapter1 extends MusicChapter {

	public List<String> getNamesOfArtists_Lambda() {
		return artists.stream()
				.map(artist -> artist.getName())
				.collect(Collectors.toList());
	}

	public List<String> getNamesOfArtists_MethodReference() {
		return artists.stream()
				.map(Artist::getName)
				.collect(Collectors.toList());
	}

	public List<Artist> artistsLivingInLondon() {
		return artists.stream()
				.filter(artist -> "London".equals(artist.getNationality()))
				.collect(Collectors.toList());
	}
}
