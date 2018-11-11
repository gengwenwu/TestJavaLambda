package org.logan.lambda.chapter4.c4_19_MultiImplements;

/**
 * desc: 多重实现演示，{@link Jukebox#rock()}也有默认方法rock <br/>
 * time: 2018/8/8 下午3:05 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
interface Carriage {

	default String rock() {
		return "... from side to side";
	}

}
