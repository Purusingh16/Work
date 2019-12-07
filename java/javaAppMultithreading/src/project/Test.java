package project;


public class Test implements Runnable
{
	public static void main(String[] args) 
	{
		Test tt=new Test();
		Thread t1=new Thread(tt,"first");
		Thread t2=new Thread(tt,"java");
		Thread t3=new Thread(tt,"interface");
		
		t1.start();
		t2.start();
		t3.start();
	}
	public void run()
	{
		for (int i = 0; i < 3; i++)
		{
			Thread aa=Thread.currentThread();
			String name=aa.getName();
			System.out.println("name:"+i);
			try
			{
				Thread.sleep(1000);
			}
			catch(InterruptedException ie)
			{
				
			}
		}
	}

}
