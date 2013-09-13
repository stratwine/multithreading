package com.concurrency.lock;

import com.concurrency.factory.ObjectMother;
import com.concurrency.objects.QueueLooper;
import com.concurrency.task.LoopTask;

public class NoLock2 {

	public static void main(String[] args) {

		QueueLooper looper = new QueueLooper(ObjectMother.aQueue());

		Runnable r1 = new LoopTask(looper);

		Thread threadOne = new Thread(r1);
		Thread threadTwo = new Thread(r1);

		threadOne.start();
		threadTwo.start();

	}
}
