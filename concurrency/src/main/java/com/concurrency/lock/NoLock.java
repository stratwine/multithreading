package com.concurrency.lock;

import java.util.Queue;

import com.concurrency.factory.ObjectMother;
import com.concurrency.task.RunnableOne;

public class NoLock {

	public static void main(String[] args) {
		
		Queue<Integer> aQueue = ObjectMother.aQueue();
		RunnableOne r1 = new RunnableOne(aQueue);
		
		
		Thread threadOne = new Thread(r1);
		Thread threadTwo = new Thread(r1);
		
		
		threadOne.start();
		threadTwo.start();
		
		
	}
}
