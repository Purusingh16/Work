package project;

public class Demo extends Thread 
{
	static Thread tt;
	
	public Demo(String name)
	{
		System.out.println("java thread");
	}
	public static void main(String[] args) 
	{
		tt=new Thread("java");
		System.out.println("thead is Alive:"+tt.isAlive());
		tt.start();
		System.out.println("thread is Alive:"+tt.isAlive());
	}
	public void run()
	{
		System.out.println("thread is running");
		tt.stop();
		System.out.println("thread is dead");
	}

}
