package multithreading;

import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args)
	{
		ArrayList<IShape> slist=new ArrayList<>();
		slist.add(new CRect("r1", 11, 10));
		slist.add(new CTraingle("t1", 10, 30));
		slist.add(new CSquire("sq", 10));
		
		ArrayList<Thread> threads = new ArrayList<>();
		
		for(IShape s : slist)
		{
			threads.add(new Thread(s));
		}
		
		for(Thread t: threads)
		{
			t.start();
		}
		
	}
	public static void main1(String[] args)
	{
		PingThread t1 = new PingThread();
		PongThread t2 = new PongThread();
		StartThread t3 = new StartThread(); 
		RunThread rt = new RunThread();
		Thread t4 = new Thread(rt);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
//		fun1();
//		fun2();
//		fun3();
	}
	
	public static void ShapeThread(String shp)
	{
		for (int i = 0; i < 10; i++) 
		{
			try
			{
				System.out.println("Creating - " + shp);
				Thread.sleep(300);
			} 
			catch (InterruptedException e)
			{
				System.out.println("INT excep: " +e.getMessage());
			}
		}
	}
	
	public static void fun1()
	{
		for (int i = 0; i < 10; i++) 
		{
			try
			{
				System.out.println("hello world !!!");
				Thread.sleep(300);
			} 
			catch (InterruptedException e)
			{
				System.out.println("INT excep: " +e.getMessage());
			}
		}
	}
	
	public static void fun2()
	{
		for (int i = 0; i < 10; i++) 
		{
			try
			{
				System.out.println("Good Morning ....");
				Thread.sleep(300);
			} 
			catch (InterruptedException e)
			{
				System.out.println("INT excep: " +e.getMessage());
			}
		}
	}
	public static void fun3()
	{
		for (int i = 0; i < 10; i++) 
		{
			try 
			{
			System.out.println("Good night !!!!");
			Thread.sleep(300);
			} 
			catch (InterruptedException e)
			{
				System.out.println("INT excep:"+e.getMessage());
			}
		}
	}
}
