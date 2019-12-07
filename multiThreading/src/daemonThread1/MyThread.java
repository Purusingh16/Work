package daemonThread1;

public class MyThread extends Thread
{
	@Override
	public void run() 
	{
//		super.run();
		for (int i = 0; i < 10; i++)
		{
			System.out.println("child Thread");
			try {
				Thread.sleep(6000);
			} catch (InterruptedException e) {
			}
		}
	}

}
