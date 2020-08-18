package com.string.pack;

import java.util.Scanner;

public class Differ {

	public static void main(String[] args) {
		
		Scanner scn=new Scanner(System.in);
		
		System.out.println("Enter an integer");
		int a=scn.nextInt();
		System.out.println("Enter a String");
		String b=scn.nextLine();
		
		System.out.println("your have entered:- "+ a +" "+"and name as"+b);
	}

}
