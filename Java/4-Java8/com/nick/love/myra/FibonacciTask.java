package com.nick.love.myra;

import java.util.concurrent.RecursiveTask;

public class FibonacciTask extends RecursiveTask<Integer> {

	private static final long serialVersionUID = 3307890928603682067L;
	
	private int index;

	public FibonacciTask(int index) {
		this.index = index;
	}

	@Override
	protected Integer compute() {
		// 当下标是最前两个元素时直接返回 1 即可
		if (index <= 2) {
			return 1;
		}
		// 否则将任务拆分成两个小任务
		FibonacciTask subTask1 = new FibonacciTask(index - 1);
		FibonacciTask subTask2 = new FibonacciTask(index - 2);
		// 将 1 号、2 号小任务放入本线程队列中 (等待其他空闲线程来执行)
		subTask1.fork();
		subTask2.fork();
		// 通过 join 方法整合两个小任务的执行结果
		 return (subTask1.join() + subTask2.join());

		// 代码改进： 因为 join 方法被调用以后本线程就阻塞了，这样本线程就浪费了

		// 通过调用 fork 方法，将 2 号任务放入本线程的队列中
		// subTask2.fork();
		// 本线程直接调用 1 号线程的业务逻辑，再调用小任务 2 的 join 方法，避免过早的进入 join 阻塞状态
		// return (subTask1.invoke() + subTask2.join());
	}
}
