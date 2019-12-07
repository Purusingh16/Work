package demo;

import java.util.Scanner;

public class Text1
{

	public static void main(String[] args) 
	{
		int arr[];
		
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter the size of the Array");
		int size=ss.nextInt();
		arr=new int[size];
		System.out.println("\nInitialize the array element");
		for (int i = 0; i < size; i++) 
		{
			arr[i]=ss.nextInt();
		}
		System.out.println("\nRetrive the array element.\n");
		for (int i : arr)
		{
			System.out.println(i+"\t");
			
		}
	}

}
