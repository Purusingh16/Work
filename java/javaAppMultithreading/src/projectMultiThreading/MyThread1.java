package projectMultiThreading;

public class MyThread1 extends Thread 
{
	public void run()
	{
		System.out.println("no-args run");
	}
	public void run(int i)
	{
		System.out.println("int args run");
	}

}
