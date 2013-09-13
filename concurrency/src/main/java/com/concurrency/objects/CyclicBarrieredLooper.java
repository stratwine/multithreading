package com.concurrency.objects;

import java.util.Queue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrieredLooper extends QueueLooper {

	Queue<Integer> queue;
	CyclicBarrier barrier = new CyclicBarrier(4);

	public CyclicBarrieredLooper(Queue<Integer> queue) {
		super(queue);
		this.queue = queue;
	}

	@Override
	public Boolean loop() {

		try {
			System.out.println(Thread.currentThread().getName()
					+ " counting down");
			barrier.await();
		} catch (InterruptedException e1) {
			System.out.println("Interrupted while waiting for countdown");
		} catch (BrokenBarrierException e) {
			System.out.println("Broken Barrier");
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
