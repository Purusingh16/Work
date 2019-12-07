package javaAssignment;

import java.util.Scanner;

public class AdditionOfNum {

	static int a,b,c;
	public static void main(String[] args) {
		System.out.println("Enter two number");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		
		c=a+b;
		System.out.println("addtion of two number is:"+c);

	}

}
