package com.concurrency.executors;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.concurrency.task.CallableOne;

public class CallableFixedES {

	final ExecutorService executor = Executors.newFixedThreadPool(4);

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException,
	ExecutionException {
		CallableFixedES pool = new CallableFixedES();

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < 100; i++) {
			queue.add(i);
		}
		Future<Boolean> future1 = (Future<Boolean>) pool.executor
		.submit(new CallableOne(queue));
		Future<?> future2 = (Future<Boolean>) pool.executor
		.submit(new CallableOne(queue));
		Future<?> future3 = (Future<Boolean>) pool.executor
		.submit(new CallableOne(queue));
		Future<?> future4 = (Future<Boolean>) pool.executor
		.submit(new CallableOne(queue));

		System.out.println(future1.get());

		System.out.println(future2.get());

		System.out.println(future3.get());

		System.out.println(future4.get());

		pool.executor.shutdown();
	}

}
