package org.logan.lambda.chapter4.c4_11_default;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * desc: {@link ParentImpl}、{@link ChildImpl} 单元测试 <br/>
 * 简言之，类中重写的方法胜出。这样的设计主要是由增加默认方法的目的决定的，增加默认方法主要是为了在接口上向后兼容。<br/>
 * 让类中重写方法的优先级高于默认方法能简化很多继承问题。<br/>
 * time: 2018/8/8 上午11:25 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class C4_DefaultTest {

	/**
	 * 当没有任何子类重写默认方法，优先使用接口中定义的默认方法
	 */
	@Test
	public void parentDefaultUsed() {
		Parent parent = new ParentImpl();
		parent.welcome();
		assertEquals("Parent: Hi!", parent.getLastMessage());
	}

	/**
	 * 优先使用重写后的默认方法
	 */
	@Test
	public void childOverrideDefault() {
		Child child = new ChildImpl();
		child.welcome();
		assertEquals("Child: Hi!", child.getLastMessage());
	}

	/**
	 * 类中重写的方法优先级高于接口中定义的默认方法
	 */
	@Test
	public void concreteBeatsDefault() {
		Parent parent = new OverridingParent();
		parent.welcome();
		assertEquals("Class Parent: Hi!", parent.getLastMessage());
	}

	/**
	 * 类中重写的方法优先级高于接口中定义的默认方法
	 */
	@Test
	public void concreteBeatsCloserDefault() {
		Child child = new OverridingChild();
		child.welcome();
		assertEquals("Class Parent: Hi!", child.getLastMessage());
	}

}