package org.logan.lambda.chapter7;

import org.logan.lambda.common.model.Album;

/**
 * desc: ThreadLocal - withInitial() <br/>
 * time: 2020/6/9 6:10 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C7_3_ThreadLocal {

	public static void main(String[] args) {
		// java8 之前的写法
		ThreadLocal<Album> thisAlbum = new ThreadLocal<Album>() {
			@Override
			protected Album initialValue() {
				return new Album("《叶惠美》");
			}
		};


		// Java 8 为ThreadLocal提供了withInitial()函数，与上面代码效果一样
		ThreadLocal<Album> thisAlbum2 = ThreadLocal.withInitial(() -> new Album("《叶惠美》"));

	}
}