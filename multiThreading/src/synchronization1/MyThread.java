package synchronization1;

public class MyThread extends Thread 
{
	Display d;
	
	public MyThread(Display d)
	{
		this.d=d;
	}
	@Override
	public void run() 
	{
		super.run();
		d.displayn();
	}

}
