package org.logan.lambda.chapter5;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

/**
 * desc: 测试流中元素的顺序 <br/>
 * time: 2018/11/11 下午1:51 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class C5_2_StreamOrderTest {

	@Test
	public void testOrder() {
		/* 有序集合测试 */
		for (int i = 0; i < 10000; i++) {
			List<Integer> numberList = Arrays.asList(1, 2, 3, 4);
			List<Integer> sameOrderList = numberList.stream()
					.collect(Collectors.toList());
			assertEquals(numberList, sameOrderList);
		}
	}

	@Test
	public void testOrder2() {
		/* 无序集合测试 */
		for (int i = 0; i < 10000; i++) {
			Set<Integer> numberSet = new HashSet<>(Arrays.asList(4, 3, 2, 1));
			List<Integer> numberList = numberSet.stream()
					.collect(Collectors.toList());
			assertEquals(Arrays.asList(4, 3, 2, 1), numberList);
		}
	}

	@Test
	public void testOrder3() {
		/* 无序变有序 */
		Set<Integer> numberList = new HashSet<>(Arrays.asList(4, 3, 2, 1));
		List<Integer> sameOrderList = numberList.stream()
				.sorted() //一些中间操作会产生顺序，如：sorted()
				.collect(Collectors.toList());
		assertEquals(Arrays.asList(1, 2, 3, 4), sameOrderList);
	}

	@Test
	public void testOrder4() {
		/*
			一些中间操作会产生顺序，譬如对值对映射。
			1，如果进来的流是有序的，那出去的流是也是有序的。
			2，如果进来的流是无序的，那出去的流是也是无序的。
		 **/
		List<Integer> numberList = Arrays.asList(1, 2, 3, 4);

		{
			/* 有序流测试 */
			for (int i = 0; i < 10000; i++) {
				List<Integer> stillOrdered = numberList.stream()
						.map(x -> x + 1)
						.collect(Collectors.toList());

				// 顺序得到了保留
				assertEquals(Arrays.asList(2, 3, 4, 5), stillOrdered);
			}
		}

		{
			/* 无序流测试 */
			for (int i = 0; i < 10000; i++) {
				Set<Integer> unordered = new HashSet<>(numberList);
				List<Integer> stillUnordered = unordered.stream()
						.map(x -> x + 1)
						.collect(Collectors.toList());

				// 顺序得不到保证
				assertThat(stillUnordered, hasItem(2));
				assertThat(stillUnordered, hasItem(3));
				assertThat(stillUnordered, hasItem(4));
				assertThat(stillUnordered, hasItem(5));
			}
		}

	}

}
