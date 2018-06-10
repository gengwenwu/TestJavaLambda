package org.logan.lambda.chapter3;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Track;

import java.util.Comparator;

/**
 * desc: max、min TODO <br/>
 * time: 2018/6/11 上午7:04 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C3_13_StreamMinAndMax {

	public static void main(String[] args) {
		Track minLengthTrack = SampleData.yeHuiMei.getTrackList()
				.stream()
				.min(Comparator.comparing(track -> track.getLength()))
				.get();
		System.out.println("最短歌曲：" + minLengthTrack.getName() + ", " + minLengthTrack.getLength());


		Track maxLengthTrack = SampleData.yeHuiMei.getTrackList()
				.stream()
				.max(Comparator.comparing(track -> track.getLength()))
				.get();
		System.out.println("最长歌曲：" + maxLengthTrack.getName() + ", " + maxLengthTrack.getLength());
	}

}
