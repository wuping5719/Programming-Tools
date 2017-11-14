package com.nick.love.myra;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class TestFibonacciTask {

	public static void main(String[] args) {
		FibonacciTask task = new FibonacciTask(20);
		ForkJoinPool pool = new ForkJoinPool();
		long startTime = System.currentTimeMillis();
		pool.submit(task);

		int result = 0;
		try {
			result = task.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();
		pool.shutdown();
		System.out.println("结果：" + result + ", 耗时：" + (endTime - startTime));
		
	}

}
