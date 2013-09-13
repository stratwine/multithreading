package com.concurrency.factory;

import java.util.LinkedList;
import java.util.Queue;

public class ObjectMother {
	public static Queue<Integer> aQueue() {
		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 0; i < 100; i++) {
			queue.add(i);
		}
		return queue;
	}
}
