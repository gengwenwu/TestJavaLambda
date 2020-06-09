package org.logan.lambda.test.reflect;


import java.util.ArrayList;
import java.util.List;

/**
 * desc: TODO <br/>
 * time: 2019/5/30 上午10:48 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class EntityType3 {

	private List<List<String>> a = new ArrayList<>();
	private Object o;


	/**
	 * @return the a
	 */
	public List<List<String>> getA() {
		return a;
	}


	/**
	 * @param a the a to set
	 */
	public void setA(List<List<String>> a) {
		this.a = a;
	}


	/**
	 * @return the o
	 */
	public Object getO() {
		return o;
	}


	/**
	 * @param o the o to set
	 */
	public void setO(Object o) {
		this.o = o;
	}
}
