package stringConcatination;

import java.util.Scanner;

public class Input 
{
	public static void main(String[] args)
	{
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter plaindrome");
		String s=ss.nextLine();
		int size=s.length();
		
		byte b1[]=s.getBytes();
		byte b2[]=new byte[size];
		
		for (int i =(size-1); i >=0; i--)
		{
			int x=size-(i+1);
			b2[x]=b1[i];
		}
		int count=0;
		for (int i = 0; i < size; i++) 
		{
			if (b1[i]==b2[i])	
					{
						count++;
					}
		}
		if (size == count)
		{
			System.out.println(s+":is a palindrome.");
		}
		else
		{
			System.out.println(s+":is not a palindrome.");
		}
	
	}
}
		
		




