package synchronization1;

public class Display 
{
	public synchronized void displayn()
	{
		for (int i = 0; i <=10; i++) 
		{
			System.out.print(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
			}
		}
	
	}
	public synchronized void displayc()
	{
		for (int i = 65; i <=75; i++) 
		{
			System.out.print((char)i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
	}

}
