package org.logan.lambda.chapter9;


import org.junit.Test;
import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;
import org.logan.lambda.common.model.Track;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * desc:  <br/>
 * time: 2020/6/29 1:34 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public class AlbumLookupTest {


	interface AlbumLookupFactory extends BiFunction<List<Track>, List<Artist>, AlbumLookup> {

	}

	@Test
	public void lookupByName() {
		Album album = SampleData.rollingStonesYears;

		List<Track> trackList = album.getTrackList();
		List<Artist> musicianList = album.getMusicianList();

		AlbumLookupFactory completable = CompletableAlbumLookup::new;
		AlbumLookupFactory future = FutureAlbumLookup::new;


		Stream.of(completable, future)
				.forEach(factory -> {
					AlbumLookup lookup = factory.apply(trackList, musicianList);
					System.out.println("Testing ==>" + lookup.getClass().getSimpleName());

					Album result = lookup.lookupByName(album.getName());

					assertEquals(trackList, result.getTrackList());
					assertEquals(musicianList, result.getMusicianList());
				});

	}

}