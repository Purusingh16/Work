package demo1;


public class Main
{
	public static void main(String[] args) 
	{
		X ab=new X();
		
		if( ab instanceof Object)
		{
			System.out.println("Equals");
		}
		else
		{
			System.out.println("Not Equals");
		}
		
		if(ab instanceof Y)
		{
			System.out.println("Equals");
		}
		else
		{
			System.out.println("Not Equals");
		}
	}

}
