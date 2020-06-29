package org.logan.lambda.chapter9;

import org.logan.lambda.common.model.Artist;

import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.rxjava3.core.Observable;

/**
 * desc:  <br/>
 * time: 2020/6/29 3:47 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class RxExamples {

	private final List<Artist> savedArtists;
	private final List<String> savedArtistNames;


	public RxExamples(List<Artist> savedArtists) {
		this.savedArtists = savedArtists;
		this.savedArtistNames = savedArtists.stream()
				.map(Artist::getName)
				.collect(Collectors.toList());
	}


	public Observable<Artist> search(String searchedName,
									 String searchedNationality,
									 int maxResults) {
		return getSavedArtists() // <1>
				.filter(name -> name.contains(searchedName))  // <2>
				.flatMap(this::lookupArtist) // <3>
				.filter(artist -> artist.getNationality().contains(searchedNationality)) // <4>
				.take(maxResults); // <5>
	}

	private Observable<String> getSavedArtists() {
		return Observable.fromIterable(savedArtistNames);
	}

	private Observable<Artist> lookupArtist(String name) {
		Artist required = savedArtists.stream()
				.filter(artist -> artist.getName().equals(name))
				.findFirst()
				.get();
		return Observable.fromArray(required);
	}

}