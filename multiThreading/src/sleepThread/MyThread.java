package sleepThread;

public class MyThread extends Thread 
{
	@Override
	public void run() 
	{
//		super.run();
		try 
		{
			for (int i = 0; i < 10; i++) 
			{
				System.out.println("i am in child thread");
				Thread.sleep(2000);
			}
			
		} catch (InterruptedException e) 
		{
			System.out.println("I got Interrupted");
		}
	}

}
