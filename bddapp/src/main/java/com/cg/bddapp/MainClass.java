package com.cg.bddapp;
public class MainClass {
	public static void main(String[] args) {
		int num=100;

		if (num<200)
			System.out.println("Hello World");
		else 
			System.out.println("Hi To All");

		// assertion is base on assumption
		//by default assertion check is disable  need to unable it  for that need to use command line args  -ea
		
		assert num <200;

		num=300;

		assert num <200;

	}

}
