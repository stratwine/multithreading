package com.concurrency.idioms;

import com.concurrency.factory.ObjectMother;
import com.concurrency.objects.QueueLooper;
import com.concurrency.objects.SemaphoredQueueLooper;
import com.concurrency.task.LoopTask;

public class SemaphoreUsage {

	public static void main(String[] args) {

		QueueLooper looper = new SemaphoredQueueLooper(ObjectMother.aQueue());

		Runnable r1 = new LoopTask(looper);

		Thread threadOne = new Thread(r1);
		Thread threadTwo = new Thread(r1);

		Thread threadThree = new Thread(r1);
		Thread threadFour = new Thread(r1);

		threadOne.start();
		threadTwo.start();
		threadThree.start();
		threadFour.start();

	}
}
