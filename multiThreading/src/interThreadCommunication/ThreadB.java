package interThreadCommunication;

public class ThreadB extends Thread 
{
	int total=0;
	
	@Override
	public void run()
	{
//		super.run();
		synchronized (this) 
		{
			System.out.println("child thread start calculation");
			for (int i = 1; i <=100; i++) 
			{
				total=total+i;
			}
			System.out.println("child giving notification call");
			this.notify();
		}
		
	}

}
