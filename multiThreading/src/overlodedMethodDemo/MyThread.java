package overlodedMethodDemo;

public class MyThread extends Thread 
{
	@Override
	public synchronized void start()
	{
		super.start();
		System.out.println("start method");
		
	}
	@Override
	public void run() 
	{
		System.out.println("no-args run");
	}
	/*public void run(int i) 
	{
		System.out.println("int-args run");
	}*/
	

}
