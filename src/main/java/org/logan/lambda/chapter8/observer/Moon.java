package org.logan.lambda.chapter8.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: 月球类 <br/>
 * time: 2020/6/22 5:58 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class Moon {

	private final List<LandingObserver> observers = new ArrayList<>();


	public void land(String name) {
		observers.forEach(observer -> {
			observer.observeLanding(name);
		});
	}

	public void startSpying(LandingObserver observer) {
		observers.add(observer);
	}

}