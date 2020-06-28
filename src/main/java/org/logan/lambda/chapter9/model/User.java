package org.logan.lambda.chapter9.model;

import java.util.Optional;
import java.util.regex.Pattern;

import io.vertx.core.Handler;
import io.vertx.core.Verticle;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.net.NetSocket;

/**
 * desc:  <br/>
 * time: 2020/6/28 4:28 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class User implements Handler<Buffer> {

	private static final Pattern newline = Pattern.compile("\\n");
	private final NetSocket socket;
	private final EventBus eventBus;
	private Optional<String> name;

	public User(NetSocket socket, Verticle verticle) {
		Vertx vertx = verticle.getVertx();
		this.socket = socket;
		eventBus = vertx.eventBus();
		name = Optional.empty();
	}

	@Override
	public void handle(Buffer buffer) {
		newline.splitAsStream(buffer.toString())
				.forEach(line -> {
					if (!name.isPresent()) {
						setName(line);
					} else {
						handleMessage(line);
					}
				});
	}

	public Optional<String> getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Optional.of(name);
	}

	private void handleMessage(String message) {
		System.out.println("handleMessage: " + message);
	}

}