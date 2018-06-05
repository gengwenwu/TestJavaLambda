package org.logan.lambda.chapter1;

import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Artist;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: TODO <br/>
 * time: 2018/4/19 下午2:18 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
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
