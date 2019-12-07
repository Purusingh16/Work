package demo;

public class ThreadDemo 
{

	public static void main0(String[] args) 
	{
		MyThread t=new MyThread();
//		t.start();
		t.run();
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("main thread");
		}
		
	}
	public static void main(String args[]) throws InterruptedException
	{
		Thread t=new Thread(new Test());
		t.start();
		System.out.println("m1");
		t.join();
		System.out.println("m2");
		
	}

}
