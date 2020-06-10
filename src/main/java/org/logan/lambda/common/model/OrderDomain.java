package org.logan.lambda.common.model;

import java.util.List;
import java.util.function.ToLongFunction;

/**
 * desc:  <br/>
 * time: 2020/6/10 3:10 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class OrderDomain {

	private List<Album> albums;


	public OrderDomain(List<Album> albums) {
		this.albums = albums;
	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public long countFeature(ToLongFunction<Album> function) {
		return this.albums.stream()
				.mapToLong(function)
				.sum();
	}

}