package org.logan.lambda.chapter8.command;

/**
 * desc: 命令者模式 - 命令 <br/>
 * time: 2020/6/22 4:30 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */

public interface Editor {

	void save();

	void open();

	void close();

}