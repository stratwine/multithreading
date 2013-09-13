package com.concurrency.idioms;

import com.concurrency.factory.ObjectMother;
import com.concurrency.objects.CountDownLatchedLooper;
import com.concurrency.objects.QueueLooper;
import com.concurrency.task.LoopTask;

public class CyclicBarrierUsage {

	public static void main(String[] args) throws InterruptedException {

		QueueLooper looper = new CountDownLatchedLooper(ObjectMother.aQueue());

		Runnable r1 = new LoopTask(looper);

		Thread threadOne = new Thread(r1);
		Thread threadTwo = new Thread(r1);

		Thread threadThree = new Thread(r1);
		Thread threadFour = new Thread(r1);
		Thread threadFive = new Thread(r1);

		threadOne.start();
		threadTwo.start();
		threadThree.start();
		System.out.println("Three Threads Started");
		Thread.sleep(4000);

		System.out.println("Starting the fourth thread");
		threadFour.start();
		threadFive.start();
		System.out.println("Started the fifth thread");

	}
}
