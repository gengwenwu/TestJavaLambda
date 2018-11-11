package org.logan.lambda.chapter4.c4_19_multi_implements;

/**
 * desc: 多重实现演示，当Carriage、Jukebox <br/>
 * time: 2018/8/8 下午3:05 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 * class Musical Carriage inherits unrelated defaults for rock() from types Carriage and Jukebox
 * return Carriage.super.rock();
 */
class MusicalCarriage implements Carriage, Jukebox { //

	/**/
	@Override
	public String rock() {
		return Jukebox.super.rock();
		//return Carriage.super.rock();
	}


}
