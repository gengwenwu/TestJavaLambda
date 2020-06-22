package org.logan.lambda.chapter8.observer;

/**
 * desc: 外星人 - 观察者 <br/>
 * time: 2020/6/22 6:01 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Aliens implements LandingObserver {

	@Override
	public void observeLanding(String name) {
		if (name.contains("Apollo")) {
			System.out.println("They're distracted, lets invade earth!");
		}
	}

}