package runnableInterface;

public class MyJoinThread extends Thread 
{
	@Override
	public void run() 
	{
		super.run();
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("seetha thread!!!");
			try {
				Thread.sleep(2000);
				} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
		}
	}

}
