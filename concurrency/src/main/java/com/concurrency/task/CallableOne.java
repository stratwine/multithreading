package com.concurrency.task;

import java.util.Queue;
import java.util.concurrent.Callable;

public class CallableOne implements Callable<Boolean> {

	Queue<Integer> list;

	public CallableOne(Queue<Integer> list) {
		this.list = list;
	}

	@Override
	public Boolean call() {

		while (!list.isEmpty()) {
			Integer integer = list.poll();
			System.out.println(Thread.currentThread().getName()
					+ " processing " + integer);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	  return true;
	}

}
