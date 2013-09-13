package com.concurrency.objects;

import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockedQueueLooperInterruptible extends QueueLooper {

	Queue<Integer> queue;
	Lock lock = new ReentrantLock();

	public LockedQueueLooperInterruptible(Queue<Integer> queue) {
		super(queue);
		this.queue = queue;
	}

	@Override
	public Boolean loop() {

		try {
			lock.lockInterruptibly();
		} catch (InterruptedException e1) {
			System.out.println("Interrupt Received");
			return false;
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
		lock.unlock();
		return true;
	}

}
