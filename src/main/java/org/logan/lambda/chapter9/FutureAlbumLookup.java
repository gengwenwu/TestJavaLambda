package org.logan.lambda.chapter9;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;
import org.logan.lambda.common.model.Track;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * desc: Future 案例 <br/>
 * 优化见： {@link CompletableAlbumLookup }
 * <p>
 * time: 2020/6/28 6:00 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class FutureAlbumLookup implements AlbumLookup {

	private static final ExecutorService SERVICE = Executors.newFixedThreadPool(2);

	private final List<Track> tracks;
	private final List<Artist> artists;

	private Track track;
	private Artist artist;


	public FutureAlbumLookup(List<Track> tracks, List<Artist> artists) {
		this.tracks = tracks;
		this.artists = artists;
	}


	@Override
	public Album lookupByName(String albumName) {
		Future<Credentials> trackLogin = loginTo("track"); // <1>
		Future<Credentials> artistLogin = loginTo("artist");

		try {
			Future<List<Track>> tracks = lookupTracks(albumName, trackLogin.get()); // <2> get()会阻塞线程
			Future<List<Artist>> artists = lookupArtists(albumName, artistLogin.get());

			return new Album(albumName, tracks.get(), artists.get()); // <3>
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		return null;
	}


	private Future<Credentials> loginTo(String serviceName) {
		return SERVICE.submit(() -> {
			if ("track".equals(serviceName)) {
				fakeWaitingForExternalWebService();
			}

			return new Credentials();
		});
	}

	private void fakeWaitingForExternalWebService() throws InterruptedException {
		Thread.sleep(1000);
	}

	private Future<List<Track>> lookupTracks(String albumName, Credentials credentials) {
		return SERVICE.submit(() -> tracks);
	}

	private Future<List<Artist>> lookupArtists(String albumName, Credentials credentials) {
		return SERVICE.submit(() -> {
			fakeWaitingForExternalWebService();
			return artists;
		});
	}

}