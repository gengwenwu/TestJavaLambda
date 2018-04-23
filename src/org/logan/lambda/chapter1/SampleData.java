package org.logan.lambda.chapter1;

import org.logan.lambda.chapter1.model.Album;
import org.logan.lambda.chapter1.model.Artist;
import org.logan.lambda.chapter1.model.Track;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * desc: 简单数据模拟 <br/>
 * time: 2018/4/19 下午1:40 <br/>
 * author: 居廉 <br/>
 * since V TODO <br/>
 */
class SampleData {

	/* 艺术家 */
	public static final Artist johnColtrane = new Artist("John Coltrane", "US");
	public static final Artist johnLennon = new Artist("John Lennon", "UK");
	public static final Artist paulMcCartney = new Artist("Paul McCartney", "UK");
	public static final Artist georgeHarrison = new Artist("George Harrison", "UK");
	public static final Artist ringoStarr = new Artist("Ringo Starr", "UK");


	public static final List<Artist> membersOfTheBeatles = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);
	public static final Artist theBeatles = new Artist("The Beatles", membersOfTheBeatles, "UK");
	public static final List<Artist> allArtists = Arrays.asList(johnLennon, paulMcCartney, georgeHarrison, ringoStarr);

	/* 专辑 */
	public static final Album aLoveSupreme = new Album("A Love Supreme", asList(new Track("Acknowledgement", 467), new Track("Resolution", 442)), asList(johnColtrane));
	public static final Album sampleShortAlbum = new Album("sample Short Album", asList(new Track("short track", 30)), asList(johnColtrane));
	public static final Album manyTrackAlbum = new Album("sample Short Album", asList(new Track("short track", 30), new Track("short track 2", 30), new Track("short track 3", 30), new Track("short track 4", 30), new Track("short track 5", 30)), asList(johnColtrane));

	public static Stream<Album> albums = Stream.of(aLoveSupreme);


	public static Stream<Artist> threeArtists() {
		return Stream.of(johnColtrane, johnLennon, theBeatles);
	}

	public static List<Artist> getThreeArtists() {
		return Arrays.asList(johnColtrane, johnLennon, theBeatles);
	}

}
