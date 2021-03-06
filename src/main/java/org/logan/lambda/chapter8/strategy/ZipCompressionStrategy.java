package org.logan.lambda.chapter8.strategy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipOutputStream;

/**
 * desc: zip 算法压缩数据   <br/>
 * time: 2020/6/22 5:30 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class ZipCompressionStrategy implements CompressionStrategy {

	@Override
	public OutputStream compress(OutputStream data) throws IOException {

		return new ZipOutputStream(data);
	}

}