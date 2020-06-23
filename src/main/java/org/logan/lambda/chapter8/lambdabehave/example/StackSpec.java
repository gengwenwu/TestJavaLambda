package org.logan.lambda.chapter8.lambdabehave.example;

import java.util.Stack;

import static org.logan.lambda.chapter8.lambdabehave.Lets.describe;

/**
 * desc:  <br/>
 * time: 2020/6/23 2:40 下午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class StackSpec {

	{ // 这里的大括号，相当于 public StackSpec() {...} 构造函数
		describe("a stack", it -> {

			it.should("be empty when created", expect -> {
				expect.that(new Stack()).isEmpty();
			});

			it.should("push new elements onto the top of the stack", expect -> {
				Stack<Integer> stack = new Stack<>();
				stack.push(1);
				expect.that(stack.get(0)).isEqualTo(1);
			});

			it.should("pop the last element pushed onto the stack", expect -> {
				Stack<Integer> stack = new Stack<>();
				stack.push(2);
				stack.push(1);
				expect.that(stack.pop()).isEqualTo(2); // 异常
			});

		});
	}

}