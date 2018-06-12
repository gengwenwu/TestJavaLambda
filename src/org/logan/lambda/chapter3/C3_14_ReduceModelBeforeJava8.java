package org.logan.lambda.chapter3;

import junit.framework.TestCase;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Track;

import java.util.List;

/**
 * desc: java8 之前的for通用模式<br/>
 * time: 2018/6/11 上午7:14 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_14_ReduceModelBeforeJava8 {


	public static void main(String[] args) {
		List<Track> tracks = SampleData.yeHuiMei.getTrackList();
		Track shortestTrack = tracks.get(0);

		for (Track track : tracks) {
			if (track.getLength() < shortestTrack.getLength()) {
				shortestTrack = track;
			}
		}

		TestCase.assertEquals(tracks.get(1), shortestTrack);
	}


	private static void showReduceMode() {
		/* reduce 模式 伪代码 */
		/*

		 Object accumulator = initialValue;

		 for(Object element : collection) {
			 accumulator = combine(accumulator, element);
		 }

		 */
	}

}
