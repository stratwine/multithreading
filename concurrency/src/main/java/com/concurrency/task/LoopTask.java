package com.concurrency.task;

import com.concurrency.objects.QueueLooper;

public class LoopTask implements Runnable{
	
	QueueLooper looper;
	
	public LoopTask(QueueLooper looper)
	{
		this.looper=looper;
	}

	@Override
	public void run() {
		looper.loop();
		
	}
	
	

}
