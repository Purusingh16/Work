package joinThread;

public class MyThread extends Thread
{
	@Override
	public void run() 
	{
//		super.run();
		for (int i = 0; i < 10; i++) 
		{
			System.out.println("child thread");
			try 
			{
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			
		}
	}

}
