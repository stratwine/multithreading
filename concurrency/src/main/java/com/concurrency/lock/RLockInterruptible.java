package com.concurrency.lock;

import com.concurrency.factory.ObjectMother;
import com.concurrency.objects.LockedQueueLooperInterruptible;
import com.concurrency.objects.QueueLooper;
import com.concurrency.task.LoopTask;

public class RLockInterruptible {

	public static void main(String[] args) throws InterruptedException {

		QueueLooper looper = new LockedQueueLooperInterruptible(ObjectMother.aQueue());

		Runnable r1 = new LoopTask(looper);

		Thread threadOne = new Thread(r1);
		Thread threadTwo = new Thread(r1);

		threadOne.start();
		threadTwo.start();
		
		Thread.sleep(1000);
		threadTwo.interrupt();
		

	}
}
