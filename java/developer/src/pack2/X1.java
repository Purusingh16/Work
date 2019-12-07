package pack2;

import java.util.Scanner;

import pack.X;

public class X1 extends X
{
	int getRoll()
	{
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter your roll number");
		roll=s1.nextInt();
		return roll;
	}
	

}
