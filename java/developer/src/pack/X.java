package pack;

import java.util.Scanner;

public class X 
{
	public String name;
	public int roll;
	
	public String getName()
	{
		System.out.println("Enter your name");
		Scanner s1=new Scanner(System.in);
		name=s1.nextLine();
		return name;
	}

}
