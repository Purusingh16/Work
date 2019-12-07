package exceptionTest;

public class Test9 
{

	
	public static void main(String[] args) throws InterruptedException 
	{
		doStuff();
	}
	public static void doStuff() /*throws InterruptedException*/
	{
		doMoreStuff();
	}
	public static void doMoreStuff() /*throws InterruptedException*/
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
