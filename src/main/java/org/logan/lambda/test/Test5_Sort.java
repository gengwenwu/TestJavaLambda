package org.logan.lambda.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.logan.lambda.common.LogUtil.printEmptyLine;

/**
 * desc: Lambda课程 一 排序 <br/>
 * time: 2018/4/27 上午11:10 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
public class Test5_Sort {

	public static void main(String[] args) {
		testSimpleSort(getUsers());
		printEmptyLine();

		testCombinationSort(getUsers());
		printEmptyLine();
	}

	/**
	 * 测试简单排序
	 */
	private static void testSimpleSort(List<User> userList) {
		System.out.println("testSimpleSort() -> ");
		/* 正向排序 */
		// 使用Comparator<T>函数接口
		userList.sort((o1, o2) -> o1.getAge() - o2.getAge());
		// 使用comparingInt()
		userList.sort(Comparator.comparingInt(User::getAge));

		/* 反向排序 */
		// 使用Comparator<T>函数接口
		// userList.sort((o1, o2) -> o2.getAge() - o1.getAge());
		// 使用comparingInt()
		userList.sort(Comparator.comparingInt(User::getAge).reversed());

		userList.forEach(System.out::println);
	}

	/**
	 * 测试组合排序
	 */
	private static void testCombinationSort(List<User> userList) {
		System.out.println("testCombinationSort() -> ");
		/* 先按照姓名排序，然后根据年龄排序，最后按照信用排序 */
		userList.sort(Comparator.comparing(User::getName)
				//.thenComparing(User::getAge).reversed()
				.thenComparing(User::getAge, ((o1, o2) -> o2 - o1)) //comparing比较器提供了重载方法,可以自定义某条属性的排序
				.thenComparing(User::getCredits));
		userList.forEach(System.out::println);
	}


	private static List<User> getUsers() {
		return Arrays.asList(
				new User("jack", 17, 10),
				new User("jack", 18, 10),
				new User("jack", 19, 11),
				new User("apple", 25, 15),
				new User("tommy", 23, 8),
				new User("jessica", 15, 13)
		);
	}

	static class User {
		private String name;
		private Integer age;
		private Integer credits;

		User(String name, Integer age, Integer credits) {
			this.name = name;
			this.age = age;
			this.credits = credits;
		}

		String getName() {
			return name;
		}

		Integer getAge() {
			return age;
		}

		Integer getCredits() {
			return credits;
		}

		@Override
		public String toString() {
			return "name:" + name + ", age:" + age + ", credits:" + credits;
		}
	}

}
