package pack;

public class Checked 
{
	void display()
	{
		System.out.println("checked Exception");
	try
	{
		throw new Exception();
	}catch(Exception ee)
	{
		System.out.println("caought the checked Exception");
	}
	
	System.out.println("I am in display method");
	}
	void fun() throws Exception 
	{
		throw new Exception();
	}
	public static void main(String[] args)
	{
		Checked cc=new Checked();
		cc.display();
		
		try {
			cc.fun();
		} catch (Exception e)
		{
			System.out.println("handled in main method");
			e.printStackTrace();
		}

	}

}
