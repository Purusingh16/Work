package runnableInterface;

public class MyThread1 extends Thread
{
	public void run()
	{
		System.out.println("run method executed by thread:"+Thread.currentThread().getName());
		
	}

}
