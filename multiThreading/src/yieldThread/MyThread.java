package yieldThread;

public class MyThread extends Thread 
{
	@Override
	public void run() 
	{
//		super.run();
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("child thread");
			Thread.yield();
			//yield method causes to pass current executing 
//			thread to give the chance of remaining waiting thread of same priority
			
		}
		
	}

}
