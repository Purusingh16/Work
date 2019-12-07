package projectMultiThreading;

public class ThreadDemo 
{
	public static void main(String[] args) 
	{
		MyThread2 myThread2=new MyThread2();
		myThread2.start();
		System.out.println("main thread");
	}
	public static void main2(String[] args) 
	{
		MyThread1 myThread1=new MyThread1();
		myThread1.start();
		
	}
	public static void main1(String[] args) 
	{
		MyThread myThread=new MyThread();
		myThread.start();
		myThread.run();
		
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println("main thread!!!");
			
		}
		
	}

}
