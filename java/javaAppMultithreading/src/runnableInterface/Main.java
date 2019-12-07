package runnableInterface;

public class Main 
{
	public static void main(String[] args) throws InterruptedException
	{
		MyJoinThread myJoinThread=new MyJoinThread();
		myJoinThread.start();
		myJoinThread.join(10000);
		for (int i = 0; i < 10; i++)
		{
			System.out.println("main thread!!!");
			
		}
		
	}
	public static void main7(String[] args)
	{
		MyYieldThread myYieldThread=new MyYieldThread();
		myYieldThread.start();
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("main thread!!!");
			
		}
	}
	public static void main6(String[] args) 
	{
		MyThread2 myThread2=new MyThread2();
		myThread2.setPriority(10);
		myThread2.start();
		
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("main thread");
		}
	}
	public static void main5(String[] args) 
	{
		System.out.println(Thread.currentThread().getPriority());
//		Thread.currentThread().setPriority(15);
		Thread.currentThread().setPriority(7);
		
		MyThread2 myThread2=new MyThread2();
		System.out.println(myThread2.getPriority());
	}
	
	public static void main4(String[] args) 
	{
		MyThread1 myThread1=new MyThread1();
		myThread1.start();
		System.out.println("main method executed by thread:"+Thread.currentThread().getName());
	}
	public static void main3(String[] args) 
	{
		System.out.println(Thread.currentThread().getName());
		MyThread myThread=new MyThread();
		System.out.println(myThread.getName());
		Thread.currentThread().setName("purushottam");
		System.out.println(Thread.currentThread().getName());
		System.out.println(10/0);
	}
	
	
	public static void main2(String[] args) 
	{
		MyThread myThread=new MyThread();
		Thread thread=new Thread(myThread);
		thread.start();
		System.out.println("main thread");
	}
	
	
	public static void main1(String[] args) 
	{
		
		MyRunnable myRunnable=new MyRunnable();
		Thread thread=new Thread(myRunnable);
//		thread.start();
		thread.run();
		for (int i = 0; i < 10; i++)
		{
			System.out.println("main thread");
			
		}

	}

}
