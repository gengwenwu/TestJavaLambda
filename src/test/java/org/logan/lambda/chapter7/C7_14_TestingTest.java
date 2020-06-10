package org.logan.lambda.chapter7;

import org.junit.Test;
import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.OrderDomain;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * desc: 在测试替身时使用Lambda表达式。 <br/>
 * Mockito
 * <p>
 * time: 2020/6/10 2:34 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class C7_14_TestingTest {

	@Test
	public void canCountFeatures() {
		OrderDomain order = new OrderDomain(
				Arrays.asList(
						new Album("Exile on Main St."),
						new Album("Beggars Banquet"),
						new Album("Aftermath"),
						new Album("Let it Bleed"))
		);


		assertEquals(8, order.countFeature(album -> 2));
	}

	@Test
	public void canCountFeaturesByMock() {
		// 使用mock制作替身
		List<String> otherList = Arrays.asList("A", "B", "C");
		List list = Mockito.mock(List.class);

		when(list.size()).thenAnswer(inv -> otherList.size());
		assertEquals(3, list.size());
	}

}