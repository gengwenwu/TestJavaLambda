package org.logan.lambda.chapter9;

import org.logan.lambda.chapter9.model.User;
import org.logan.lambda.chapter9.vertx.Runner;

import io.vertx.core.AbstractVerticle;

/**
 * desc: Vert.x 服务器端 <br/>
 * time: 2020/6/28 3:53 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public class VertXEchoServer extends AbstractVerticle {

	public static void main(String[] args) {
		Runner.runExample(VertXEchoServer.class);
	}

	@Override
	public void start() throws Exception {
		vertx.createNetServer()
				.connectHandler(socket -> {
					// 每当有用户连接到该服务器的时候，都会调用该 Lambda 表达式，其实这就是一个回调。
					// Pump.pump(socket, socket).start();
					socket.handler(new User(socket, this));
				}).listen(10_000);

		System.out.println("Echo server is now listening");
	}

}
