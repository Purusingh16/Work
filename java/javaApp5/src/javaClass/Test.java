	package javaClass;

import java.util.Scanner;

public class Test {

	
	public static void main(String[] args)
	{
		/*System.out.println(args.length);
		if(args.length>0)
			System.out.println(args[0]);*/
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter num1");
		int num1=sc.nextInt();
		System.out.println("Enter num2");
		int num2=sc.nextInt();
		
		System.out.println("Enter operation:");
		int operation=sc.nextInt();
		
		if(operation==1)
		{
			int add=addition(num1,num2);
			System.out.println("total addition:"+add);
		}
		else if(operation==2)
		{
			int sub=subtraction(num1,num2);
			System.out.println("total subtraction:"+sub);
		}
		else if(operation==3)
		{
			int multi=multiplication(num1,num2);
			System.out.println("total multiplication:"+multi);
		}
		 else
		 {
			 int div=division(num1,num2);
				System.out.println("total division:"+div);
		 }
		
		
		/*int add=addition(num1,num2);
		System.out.println("total addition:"+add);*/
		
		/*int sub=subtraction(num1,num2);
		System.out.println("total subtraction:"+sub);
		
		int multi=multiplication(num1,num2);
		System.out.println("total multiplication:"+multi);
		
		int div=division(num1,num2);
		System.out.println("total division:"+div);*/
		
	}
	public static int addition(int num1,int num2)
	{
		return num1+num2;
	}
	public static int subtraction(int num1,int num2)
	{
		return num1-num2;
	}
	public static int multiplication(int num1,int num2)
	{
		return num1*num2;
	}
	public static int division(int num1,int num2)
	{
		return num1/num2;
	}
}
