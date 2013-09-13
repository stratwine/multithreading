package com.concurrency.lock;

import java.util.Queue;

import com.concurrency.factory.ObjectMother;
import com.concurrency.task.RunnableOneSynchronized;

public class IntrinsicLock {

	public static void main(String[] args) {
		
		Queue<Integer> aQueue = ObjectMother.aQueue();
		
		Runnable r1 = new RunnableOneSynchronized(aQueue);
		
		
		Thread threadOne = new Thread(r1);
		Thread threadTwo = new Thread(r1);
		
		
		threadOne.start();
		threadTwo.start();
		
		
	}
}
