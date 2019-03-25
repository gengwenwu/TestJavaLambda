package org.logan.lambda.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * desc: 手动使用线程模拟掷骰子事件 <br/>
 * time: 2019/3/23 下午9:16 <br/>
 * author: Logan <br/>
 * since V 1.0 <br/>
 */
class C6_3_ManualDiceRolls {

	private static final int N = 100000000;

	private final double fraction;
	private final Map<Integer, Double> results;
	private final int numberOfThreads;
	private final ExecutorService executor;
	private final int workPerThread;

	public static void main(String[] args) {
		C6_3_ManualDiceRolls roles = new C6_3_ManualDiceRolls();

		System.out.println("serial begin...");
		long time = System.currentTimeMillis();
		roles.simulateDiceRoles();
		System.out.println("serial end。==========> useTime:" + (System.currentTimeMillis() - time));
	}

	private C6_3_ManualDiceRolls() {
		fraction = 1.0 / N;
		results = new ConcurrentHashMap<>();
		numberOfThreads = Runtime.getRuntime().availableProcessors();
		executor = Executors.newFixedThreadPool(numberOfThreads);
		workPerThread = N / numberOfThreads;
	}

	private void simulateDiceRoles() {
		List<Future<?>> futures = submitJobs();
		awaitCompletion(futures);
		printResults();
	}

	private void printResults() {
		results.entrySet()
				.forEach(System.out::println);
	}

	private List<Future<?>> submitJobs() {
		List<Future<?>> futures = new ArrayList<>();
		for (int i = 0; i < numberOfThreads; i++) {
			futures.add(executor.submit(makeJob()));
		}
		return futures;
	}

	private Runnable makeJob() {
		return () -> {
			ThreadLocalRandom random = ThreadLocalRandom.current();
			for (int i = 0; i < workPerThread; i++) {
				int entry = twoDiceThrows(random);
				accumulateResult(entry);
			}
		};
	}

	private void accumulateResult(int entry) {
		results.compute(entry, (key, previous) ->
				previous == null ? fraction
						: previous + fraction
		);
	}

	private int twoDiceThrows(ThreadLocalRandom random) {
		int firstThrow = random.nextInt(1, 7);
		int secondThrow = random.nextInt(1, 7);
		return firstThrow + secondThrow;
	}

	private void awaitCompletion(List<Future<?>> futures) {
		futures.forEach((future) -> {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		});
		executor.shutdown();
	}

}
