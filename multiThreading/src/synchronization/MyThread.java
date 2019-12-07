package synchronization;

public class MyThread extends Thread 
{
	Display d;
	String name;
	
	public MyThread(Display d,String name) 
	{
		this.d=d;
		this.name=name;
	}
	@Override
	public void run() 
	{
//		super.run();
		d.wish(name);
	}

}
