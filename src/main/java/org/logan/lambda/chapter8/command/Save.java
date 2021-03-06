package org.logan.lambda.chapter8.command;

/**
 * desc: save 操作代理给 Editor 方法   <br/>
 * time: 2020/6/22 4:36 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class Save implements Action {

	private final Editor editor;

	public Save(Editor editor) {
		this.editor = editor;
	}

	@Override
	public void perform() {
		editor.save();
	}

}