package com.concurrency.task;

import java.util.Queue;

public class RunnableOne implements Runnable {

	Queue<Integer> list;

	public RunnableOne(Queue<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {

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
	}

}
