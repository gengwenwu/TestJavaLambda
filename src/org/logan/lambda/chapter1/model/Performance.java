package org.logan.lambda.chapter1.model;

import java.util.stream.Stream;

/**
 * desc: 演出 <br/>
 * time: 2018/4/19 下午1:38 <br/>
 * author: 居廉 <br/>
 * since V TODO <br/>
 */
public interface Performance {

	String getName();

	Stream<Artist> getMusicians();

	// TODO: test
	default Stream<Artist> getAllMusicians() {
		return getMusicians().flatMap(artist -> {
			return Stream.concat(Stream.of(artist), artist.getMembers());
		});
	}

}
