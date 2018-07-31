package org.logan.lambda.chapter4;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Album;

import java.util.IntSummaryStatistics;

/**
 * Java8 提供了IntStream、DoubleStream、LongStream 对基本数据类型处理， <br/>
 * 应尽可能使用对基本类型做过特殊处理的方法，进而改善性能。 <br/>
 * time: 2018/7/31 下午1:30 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C4_2_BaseType {

	public static void main(String[] args) {
		printTrackLengthStatics(SampleData.rollingStonesYears);
	}

	private static void printTrackLengthStatics(Album album) {
		IntSummaryStatistics trackLengthStats =
				album.getTracks()
						.mapToInt(track -> track.getLength()) //将Length转换为int基本类型，返回 IntStream
						// mapToDouble() // 将Length转换为double，返回 DoubleStream
						// .mapToLong() // 将Length转换为long，返回 LongStream
						// .map(length -> length + 10) // IntStream的map参数为IntUnaryOperator，即：整型值映射成另一个整型值
						// .mapToObj(length -> length) //高阶函数装箱方法，将Length转换为包装类型，转换为Stream
						.summaryStatistics();

		System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d"
				, trackLengthStats.getMax()
				, trackLengthStats.getMin()
				, trackLengthStats.getAverage()
				, trackLengthStats.getSum());
	}

}
