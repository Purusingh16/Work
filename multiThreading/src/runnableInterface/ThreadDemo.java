package runnableInterface;

import demo.MyThread;

public class ThreadDemo {

	public static void main(String[] args) 
	{
		MyThread r=new MyThread();
		Thread t=new Thread(r);
		t.start();
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("main thread");
		}
	}

}
