package org.logan.lambda.chapter8.strategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

/**
 * desc: 测试模式 测试类 <br/>
 * time: 2020/6/22 5:33 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class MainTest {

	public static void main(String[] args) throws IOException {
		runByJavaNormal();
		runByLambda();
	}

	private static void runByJavaNormal() throws IOException {
		Path inFile = Paths.get("");
		File outFile = new File("");

		// gzip
		Compressor gzipCompressor = new Compressor(new GzipCompressionStrategy());
		gzipCompressor.compress(inFile, outFile);

		// zip
		Compressor zipCompressor = new Compressor(new ZipCompressionStrategy());
		zipCompressor.compress(inFile, outFile);
	}

	private static void runByLambda() throws IOException {
		Path inFile = Paths.get("");
		File outFile = new File("");

		// gzip
		Compressor gzipCompressor = new Compressor(GZIPOutputStream::new); // 去掉GzipCompressionStrategy 实现类
		gzipCompressor.compress(inFile, outFile);

		// zip
		Compressor zipCompressor = new Compressor(ZipOutputStream::new); // 去掉ZipCompressionStrategy 实现类
		zipCompressor.compress(inFile, outFile);

	}

}