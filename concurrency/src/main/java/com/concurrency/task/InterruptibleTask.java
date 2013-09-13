package com.concurrency.task;

import java.util.Queue;

public class InterruptibleTask implements Runnable {

	Queue<Integer> list;

	public InterruptibleTask(Queue<Integer> list) {
		this.list = list;
	}

	@Override
	public void run() {

		while (!list.isEmpty()) {
			Integer integer = list.poll();
			System.out.println(Thread.currentThread().getName()
					+ " processing " + integer);

			if(Thread.interrupted())
			{
				System.out.println("Stopping Thread"+Thread.currentThread().getName());
				return;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("(Interrupted while sleeping) Stopping Thread"+Thread.currentThread().getName());
				System.out.println("Is interrupted?:"+Thread.interrupted());
				return;
			}
		}
	}

}
