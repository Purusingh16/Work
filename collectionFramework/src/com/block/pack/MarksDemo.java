package com.block.pack;

public class MarksDemo {

	public static void main(String[] args) {
		
				//first object
				Marks marks=new Marks();
				marks.engMarks=70;
				marks.mathsMarks=100;
				marks.phyMarks=70;
				
				//second object
				Marks marks1=new Marks();
				marks1.engMarks=80;
				marks1.mathsMarks=90;
				marks1.phyMarks=60;
				
				//displaying for first object
				System.out.println("marks for first object : ");
				System.out.println(marks.engMarks);
				System.out.println(marks.mathsMarks);
				System.out.println(marks.phyMarks);
				
				//displaying for second object
				System.out.println("marks for second object : ");
				System.out.println(marks1.engMarks);
				System.out.println(marks1.mathsMarks);
				System.out.println(marks1.phyMarks);
				}

}


