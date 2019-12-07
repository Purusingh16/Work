package file_Input_output;

import java.util.Scanner;

public class ReadArray {

	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int size=0;
		System.out.println("Enter size of array:-");
		
		size=sc.nextInt();
		int a[]=new int[size];
		System.out.println("Enter element of array:-");
		for(int index=0;index<size;index++)
		{
			a[index]=sc.nextInt();
		}
		for(int index=0;index<size;index++)
		{
			System.out.println((a[index]));
		}
	}

}
