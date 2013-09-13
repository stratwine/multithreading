package com.concurrency.objects;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchedLooper extends QueueLooper {

	Queue<Integer> queue;
	CountDownLatch latch = new CountDownLatch(4);

	public CountDownLatchedLooper(Queue<Integer> queue) {
		super(queue);
		this.queue = queue;
	}

	@Override
	public Boolean loop() {

		try {
			System.out.println(Thread.currentThread().getName()+" counting down");
			latch.countDown();
			latch.await();
		} catch (InterruptedException e1) {
			System.out.println("Interrupted while waiting for countdown");
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
		
		return true;
	}

}
