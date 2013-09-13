package com.concurrency.task;

public class RunnableTwo implements Runnable{
	
	@Override
	public void run()
	{

		System.out.println("I am printing Runnable 2\n");
		for(int i=0;i<100;i++)
		{
			System.out.print("R2:"+i+",");
		}
	}

}
