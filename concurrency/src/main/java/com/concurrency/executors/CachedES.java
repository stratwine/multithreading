package com.concurrency.executors;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.concurrency.task.RunnableOne;

public class CachedES {

	final ExecutorService executor = Executors.newCachedThreadPool();

	public static void main(String[] args) throws InterruptedException {
		CachedES pool = new CachedES();

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
		
		Thread.sleep(10000);
		
		pool.executor.execute(new RunnableOne(queue2));
		pool.executor.execute(new RunnableOne(queue2));
		pool.executor.execute(new RunnableOne(queue2));
		pool.executor.execute(new RunnableOne(queue2));


		pool.executor.shutdown();
	}

}
