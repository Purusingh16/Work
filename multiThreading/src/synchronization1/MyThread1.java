package synchronization1;

public class MyThread1 extends Thread 
{
	Display d;
	
	public MyThread1(Display d) 
	{
		this.d=d;
	}
	@Override
	public void run() 
	{
//		super.run();
		d.displayc();
	}

}
