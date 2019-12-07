package threading;

import java.util.ArrayList;

public class Main 
{
	public static void main(String[] args) 
	{
		ArrayList<IEmployee> elist=new ArrayList<>();
		elist.add(new IEngineer(101, 6, 100, "jack", 5000));
		elist.add(new IManager(102, "tom",6000, 400));
		
		ArrayList<Thread> threads=new ArrayList<>();
		
		for (IEmployee iEmployee : elist) 
		{
			threads.add(new Thread(iEmployee));
		}
		for (Thread t : threads)
		{
			t.start(); 
		}
	}
	public static void employeeThread(String emp)
	{
		for (int i = 0; i < 10; i++) 
		{
			try 
			{
				System.out.println("Creating :"+emp);
				Thread.sleep(300);
			} 
			catch (InterruptedException e) 
			{
				System.out.println("INT excep:"+e.getMessage());
			}
		}
	}

}
