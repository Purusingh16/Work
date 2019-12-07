package commandLine;

import java.util.Scanner;

public class SS
{
	public static void main(String[] args) 
	{
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter your name");
		String name=s1.nextLine();
		System.out.println("Enter your Roll number");
		int roll=s1.nextInt();
		System.out.println("Enter your fee");
		double fee=s1.nextDouble();
		
		System.out.println("Name is:"+name+"\nRoll number is:"+roll+"\nFee is:"+fee);
		

	}

}
