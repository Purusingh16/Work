package synchronization;

public class Display 
{
	public static synchronized void wish(String name)
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

	

}
