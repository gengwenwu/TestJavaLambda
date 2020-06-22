package org.logan.lambda.chapter8.strategy;

import java.io.IOException;
import java.io.OutputStream;

/**
 * desc: 压缩数据的策略接口 <br/>
 * time: 2020/6/22 5:27 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public interface CompressionStrategy {

	OutputStream compress(OutputStream data) throws IOException;

}