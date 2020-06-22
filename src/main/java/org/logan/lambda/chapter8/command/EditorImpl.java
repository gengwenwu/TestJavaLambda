package org.logan.lambda.chapter8.command;

/**
 * desc: 命令者模式 - 命令 <br/>
 * time: 2020/6/22 4:30 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class EditorImpl implements Editor {

	@Override
	public void save() {
		System.out.println("save");
	}

	@Override
	public void open() {
		System.out.println("open");
	}

	@Override
	public void close() {
		System.out.println("close");
	}

}