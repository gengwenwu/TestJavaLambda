package org.logan.lambda.chapter8.strategy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * desc: 提供压缩策略  <br/>
 * time: 2020/6/22 5:31 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Compressor {

	private final CompressionStrategy strategy;

	public Compressor(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	public void compress(Path inFile, File outFile) throws IOException {
		try (OutputStream outStream = new FileOutputStream(outFile)) {
			Files.copy(inFile, strategy.compress(outStream));
		}
	}

}