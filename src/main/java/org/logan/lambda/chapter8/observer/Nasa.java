package org.logan.lambda.chapter8.observer;

/**
 * desc: Nasa - 观察者 <br/>
 * time: 2020/6/22 6:02 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Nasa implements LandingObserver {

	@Override
	public void observeLanding(String name) {
		if (name.contains("Apollo")) {
			System.out.println("We made it!");
		}
	}

}