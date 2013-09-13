package com.concurrency.interrupts;

import java.util.Queue;

import com.concurrency.factory.ObjectMother;
import com.concurrency.task.InterruptibleTask;

public class CheckInterruptStatusAfterInterrupt {

	public static void main(String[] args) throws InterruptedException {

		Queue<Integer> aQueue = ObjectMother.aQueue();

		Runnable r1 = new InterruptibleTask(aQueue);

		Thread threadOne = new Thread(r1);
		Thread threadTwo = new Thread(r1);
		Thread threadThree = new Thread(r1);

		threadOne.start();
		threadTwo.start();
		threadThree.start();
		
		Thread.sleep(925);
		threadOne.interrupt();
		Thread.sleep(245);
		threadTwo.interrupt();
		Thread.sleep(1102);
		threadThree.interrupt();

	}
}
