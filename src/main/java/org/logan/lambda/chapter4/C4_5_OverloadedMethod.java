package org.logan.lambda.chapter4;

import java.util.function.BinaryOperator;
import java.util.function.Predicate;

/**
 * desc: Lambda重载 <br/>
 * Lambda 表达式作为参数时，其类型由它的目标类型推导得出，推导过程遵循如下规则:
 * 1，如果只有一个可能的目标类型，由相应函数接口里的参数类型推导得出;
 * 2，如果有多个可能的目标类型，由最具体的类型推导得出;
 * 3，如果有多个可能的目标类型且最具体的类型不明确，则需人为指定类型（强转Lambda表达式 或 继承）。
 * time: 2018/7/31 下午2:38 <br/>
 * author: Logan <br/>
 * since V 1。0 <br/>
 */
class C4_5_OverloadedMethod {

	public static void main(String[] args) {
		overloadedMethod("abc");

		overloadedMethod((x, y) -> x + y);

		// overloadedMethod(x -> true);
		/* 强转 -> 代码异味 */
		// overloadedMethod((Predicate)x -> true);
		// overloadedMethod((IntPredicate)x -> true);
	}

	//============== 重载1
	private static void overloadedMethod(Object o) {
		System.out.println("Object");
	}

	private static void overloadedMethod(String s) {
		System.out.println("String");
	}

	//============== 重载2

	private static void overloadedMethod(BinaryOperator<Integer> lambda) {
		System.out.println("BinaryOperator");
	}

	private static void overloadedMethod(IntegerBiFunction lambda) {
		System.out.println("IntegerBiFunction");
	}

	private interface IntegerBiFunction extends BinaryOperator<Integer> {

	}

	//============== 重载3
	private static void overloadedMethod(Predicate<Integer> predicate) {
		System.out.print("Predicate");
	}

	private static void overloadedMethod(IntPredicate predicate) {
		System.out.print("IntPredicate");
	}

	private interface IntPredicate { //extends Predicate
		boolean test(int value);
	}

}
