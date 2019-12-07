package multithreading;

public class PingThread extends Thread
{
	@Override
	public void run() 
	{
		super.run();
		Main.fun1();
	}
}
