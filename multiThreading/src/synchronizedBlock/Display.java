package synchronizedBlock;

public class Display 
{
	public  void wish(String name)
	{
		;;;;;;;;;;//lines of codes
//		synchronized (this) 
		synchronized(Display.class)
		{
		for (int i = 0; i < 10; i++)
		{
			System.out.print("Good Morning:");
			try 
			{
				Thread.sleep(2000);
			} catch (InterruptedException e){}
			System.out.println(name);
		}
		}
		;;;;;;;;;;;;;//lines of codes
	}

}
