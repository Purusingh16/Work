package pack;

public class UnChecked 
{
	void display()
	{
		System.out.println("unchecked Exception");
		try
		{
			throw new Error();
		}catch(Error e)
		{
			System.out.println("Handled the Exception");
		}
		System.out.println("I am in display method");
	}
	void fun()
	{
		throw new Error();
	}
	public static void main(String[] args) 
	{
		UnChecked unChecked=new UnChecked();
		unChecked.display();
		
		unChecked.fun();
		
		
	}

}
