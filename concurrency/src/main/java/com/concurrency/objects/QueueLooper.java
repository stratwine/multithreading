package com.concurrency.objects;

import java.util.Queue;

public class QueueLooper {
	
	Queue<Integer> queue;
	
	public QueueLooper(Queue<Integer> queue)
	{
	  this.queue=queue;	
	}
	
	public Boolean loop() {

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
