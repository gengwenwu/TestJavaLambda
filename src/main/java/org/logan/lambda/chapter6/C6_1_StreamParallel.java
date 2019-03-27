package org.logan.lambda.chapter6;

import org.logan.lambda.common.SampleData;
import org.logan.lambda.common.model.Album;
import org.logan.lambda.common.model.Track;

import java.util.function.Supplier;

/**
 * desc: 并行化流操作 <br/>
 * time: 2019/3/23 下午8:46 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C6_1_StreamParallel {

	public static void main(String[] args) {
		recordMethodUsedTime("串行方式", C6_1_StreamParallel::serialArraySum);

		recordMethodUsedTime("并行方式", C6_1_StreamParallel::parallelArraySum);
	}

	/**
	 * 所有专辑歌曲总长度 - 串行方式
	 */
	private static int serialArraySum() {
		return SampleData.allAlbums.stream()
				.flatMap(Album::getTracks)
				.mapToInt(Track::getLength)
				.sum();
	}

	/**
	 * 所有专辑歌曲总长度 - 并行方式
	 */
	private static int parallelArraySum() {
		return SampleData.allAlbums.parallelStream()
				.flatMap(Album::getTracks)
				.mapToInt(Track::getLength)
				.sum();
	}

	static <T> void recordMethodUsedTime(String flag, Supplier<T> supplier) {
		long time = System.currentTimeMillis();
		T t = supplier.get();
		System.err.println("=======>" + flag + " -> :" + t + ", 运行时长:" + (System.currentTimeMillis() - time));
	}

}
