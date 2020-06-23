package org.logan.lambda.chapter8.lambdabehave;

/**
 * desc:  <br/>
 * time: 2020/6/23 2:51 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public final class Lets {

	public static void describe(String name, Suite behavior) {
		Description description = new Description(name);
		behavior.specifySuite(description);
	}

}