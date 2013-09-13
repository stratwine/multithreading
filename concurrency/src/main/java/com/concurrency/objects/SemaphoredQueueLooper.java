package com.concurrency.objects;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class SemaphoredQueueLooper extends QueueLooper {

	Queue<Integer> queue;
	Semaphore semaphore = new Semaphore(2);

	public SemaphoredQueueLooper(Queue<Integer> queue) {
		super(queue);
		this.queue = queue;
	}

	@Override
	public Boolean loop() {

		try {
			semaphore.acquire();
		} catch (InterruptedException e1) {
			System.out.println("Semaphore Acquisition Blocked");
		}
		while (!queue.isEmpty()) {
			Integer integer = queue.poll();
			System.out.println(Thread.currentThread().getName()
					+ " processing " + integer);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("Interrrupted");
			}
		}
		semaphore.release();
		return true;
	}

}
