package com.concurrency.executors;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.concurrency.task.RunnableOne;

public class FixedES {

	final ExecutorService executor = Executors.newFixedThreadPool(4);

	public static void main(String[] args) {
		FixedES pool = new FixedES();

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < 100; i++) {
			queue.add(i);
		}
		pool.executor.execute(new RunnableOne(queue));
		pool.executor.execute(new RunnableOne(queue));
		pool.executor.execute(new RunnableOne(queue));
		pool.executor.execute(new RunnableOne(queue));


		pool.executor.shutdown();
	}

}
