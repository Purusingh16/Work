package com.block.pack;

public class StudentDetails {
	
	public void studentAge()
	{
		//local variable
		int age=0;
		age=age + 5;
		System.out.println("Student age is : "+ age);
	}

	public static void main(String[] args) {
		StudentDetails details=new StudentDetails();
		details.studentAge();

	}

}
