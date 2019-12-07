package multithreading;

public class PongThread extends Thread 
{
	@Override
	public void run() 
	{
		super.run();
		Main.fun2();
	}
}
