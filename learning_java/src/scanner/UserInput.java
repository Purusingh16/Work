package scanner;

import java.util.Scanner;

public class UserInput 
{
	
	public static void main_(String[] args)
	{
		int array[]=new int[5];
		
		array[0]=10;
		array[1]=20;
		array[2]=30;
		array[3]=40;
		array[4]=50;
		for(int index=0;index<5;index++)
		{
			System.out.println(array[index]);
		}
		System.out.println("********");
		
		int array1[]={23,47,48,59,69};
		int sum=0;
		for(int index=0;index<array1.length;index++)
		{
//			System.out.println(array1[index]);
			sum=sum+array1[index];
		}
		System.out.println("total sum:"+sum);
		System.out.println("total average:"+sum/array1.length);
			
		
	}
	public static void main2(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter first number");
		int fnumber=scanner.nextInt();
		System.out.println("enter second number");
		int snumber=scanner.nextInt();
		int sum=fnumber+snumber;
		System.out.println("sum of two number:"+sum);
	}

	public static void main(String[] args)
	{	
		Scanner scan=new Scanner(System.in);
		System.out.println("Please enter the size of element:");
		int maxSize=scan.nextInt();
		for (int i = 0; i <maxSize; i++)
		{
			System.out.println(scan.nextInt());
		}

	}

}
