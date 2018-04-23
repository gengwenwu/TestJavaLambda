package org.logan.lambda.chapter1;

import org.logan.lambda.chapter1.model.Album;
import org.logan.lambda.chapter1.model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: TODO <br/>
 * time: 2018/4/19 下午2:18 <br/>
 * author: 居廉 <br/>
 * since V TODO <br/>
 */
public abstract class MusicChapter {

	protected final List<Artist> artists;
	protected final List<Album> albums;

	public MusicChapter() {
		artists = new ArrayList<>();
		albums = new ArrayList<>();
		loadData("");
	}

	private void loadData(String file) {

	}

}
