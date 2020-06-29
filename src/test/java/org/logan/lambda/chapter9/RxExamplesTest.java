package org.logan.lambda.chapter9;


import org.junit.Test;
import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Artist;

import static org.junit.Assert.assertEquals;

/**
 * desc:  <br/>
 * time: 2020/6/29 4:19 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class RxExamplesTest {

	@Test
	public void search() {
		RxExamples examples = new RxExamples(SampleData.getThreeArtists());
		Artist artist = examples
				.search("周杰伦", "中国台湾", 2)
				.toList()
				.blockingGet()
				.get(0);

		assertEquals(SampleData.zhouJieLun, artist);
	}

}