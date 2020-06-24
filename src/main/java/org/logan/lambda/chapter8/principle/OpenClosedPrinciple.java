package org.logan.lambda.chapter8.principle;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * desc: 开闭原则 <br/>
 * time: 2020/6/23 5:39 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class OpenClosedPrinciple {

	public static void main(String[] args) {
		//
		ThreadLocal<DateFormat> localFormatter
				= ThreadLocal.withInitial(SimpleDateFormat::new);
		DateFormat formatter = localFormatter.get();

		//
		AtomicInteger threadId = new AtomicInteger();
		ThreadLocal<Integer> localId =
				ThreadLocal.withInitial(threadId::getAndIncrement);
		int idForThisThread = localId.get();
		System.out.println("======>" + idForThisThread);
	}

}