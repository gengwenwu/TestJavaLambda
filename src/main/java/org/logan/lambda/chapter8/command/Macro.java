package org.logan.lambda.chapter8.command;

import java.util.ArrayList;
import java.util.List;

/**
 * desc: 宏 <br/>
 * time: 2020/6/22 4:41 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public class Macro {

	private final List<Action> actions;

	public Macro() {
		actions = new ArrayList<>(2);
	}


	public void record(Action action) {
		actions.add(action);
	}


	public void run() {
		actions.forEach(Action::perform);
	}

}