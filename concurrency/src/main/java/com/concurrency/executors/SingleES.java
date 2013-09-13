package com.concurrency.executors;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.concurrency.task.RunnableOne;

public class SingleES {

	final ExecutorService executor = Executors.newSingleThreadExecutor();

	public static void main(String[] args) throws InterruptedException {
		SingleES pool = new SingleES();

		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> queue2 = new LinkedList<Integer>();

		for (int i = 0; i < 100; i++) {
			queue.add(i);
			queue2.add(i);
		}
		pool.executor.execute(new RunnableOne(queue));
		pool.executor.execute(new RunnableOne(queue));
		pool.executor.execute(new RunnableOne(queue));
		pool.executor.execute(new RunnableOne(queue));



		pool.executor.shutdown();
	}

}
