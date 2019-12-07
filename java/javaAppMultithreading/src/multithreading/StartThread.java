package multithreading;

public class StartThread extends Thread 
{
	@Override
	public void run() 
	{
		super.run();
		Main.fun3();
	}
}
