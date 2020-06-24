package org.logan.lambda.chapter8.lambdabehave.principle;

import java.util.stream.IntStream;

/**
 * desc: 单一责任链原则 <br/>
 * time: 2020/6/24 10:20 上午 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class SingleResponsibilityPrinciple {


	public interface PrimeCounter {

		long countPrimes(int upTo);
	}

	// 实现方式一：将所有代码堆在一个函数里
	public static class ImperativeSingleMethodPrimeCounter implements PrimeCounter {

		@Override
		public long countPrimes(int upTo) {
			long tally = 0;

			for (int i = 0; i < upTo; i++) {
				boolean isPrime = true;

				for (int j = 2; j < i; j++) {
					if (i % j == 0) {
						isPrime = false;
					}
				}

				if (isPrime) {
					tally++;
				}
			}

			return 0;
		}
	}

	// 实现方式二：抽离函数，再引用
	public static class ImperativeRefactoredPrimeCounter implements PrimeCounter {

		@Override
		public long countPrimes(int upTo) {
			long tally = 0;

			for (int i = 1; i < upTo; i++) {
				if (isPrime(i)) {
					tally++;
				}
			}

			return tally;
		}

		private boolean isPrime(int number) {
			for (int i = 2; i < number; i++) {
				if (number % i == 0) {
					return false;
				}
			}

			return true;
		}

	}

	// 实现方式三(最终方案)： 使用Stream、Function，单一责任
	public static class FunctionalPrimeCounter implements PrimeCounter {

		@Override
		public long countPrimes(int upTo) {
			return IntStream.range(1, upTo)
					.filter(this::isPrime) // 函数引用
					.count();
		}

		// function
		private boolean isPrime(int number) {
			return IntStream.range(0, number)
					.allMatch(x -> (number % x) != 0);
		}
	}

}