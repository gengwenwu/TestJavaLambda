package org.logan.lambda.chapter9;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;
import org.logan.lambda.common.model.Track;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * desc: CompletableFuture 案例 <br/>
 * time: 2020/6/29 11:09 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class CompletableAlbumLookup implements AlbumLookup {

	private static final ExecutorService SERVICE = Executors.newFixedThreadPool(2);

	private final List<Track> tracks;
	private final List<Artist> artists;


	public CompletableAlbumLookup(List<Track> tracks, List<Artist> artists) {
		this.tracks = tracks;
		this.artists = artists;
	}


	@Override
	public Album lookupByName(String albumName) {
		CompletableFuture<List<Artist>> artistLookup
				= loginTo("artist")
				.thenCompose(artistLogin -> lookupArtists());

		return loginTo("track")
				.thenCompose(trackLogin -> lookupArtists())
				.thenCombine(artistLookup, (tra, art)
						-> new Album(albumName, tracks, artists))
				.join();

	}

	private CompletableFuture<Credentials> loginTo(String serviceName) {
		return CompletableFuture.supplyAsync(() -> {
			if ("artist".equals(serviceName)) {
				sleep(1000);
			}
			return new Credentials();
		}, SERVICE);
	}

	private CompletableFuture<List<Artist>> lookupArtists() {
		return CompletableFuture.completedFuture(artists);
	}


	private CompletableFuture<List<Track>> lookupTracks(String albumName, Credentials credentials) {
		return CompletableFuture.supplyAsync(() -> {
			// 这里会做一些繁重的工作
			sleep(1000);
			return tracks;
		}, SERVICE);
	}


	private void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}