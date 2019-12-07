package project;

import java.util.Random;

public class Employee 
{
	private String name;
	private	int age;
	private char gender;
	private double salary;
	
	private static String compName;
	static int empCount;
	
	//Static init block - invoked only once
	static 
	{
		compName="IBM";
		empCount=100;
	}
	//Initialization Block - invoked whenever object is created
	{
		Random r=new Random();
		this.age=r.nextInt(100);
		empCount++;
	}
	
public Employee()
{
//	this.age=35;
	this.gender='m';
	this.name="tom";
	this.salary=11000.56;
}
public Employee(String name,int age,char gender,double salary)
{
	this.name=name;
//	this.age=age;
	this.gender=gender;
	this.salary=salary;
}
public Employee(Employee e)
{
//	this.age=e.age;
	this.gender=e.gender;
	this.name=e.name;
	this.salary=e.salary;
}
public void setEmpInfo(String name,int age,char gender,double salary)
{
	this.age=age;
	this.gender=gender;
	this.name=name;
	this.salary=salary;
	
}
public String getEmpInfo()
{
	return "empInfo="+this.age+" "+this.gender+" "+this.name+" "+this.salary+" "+compName;
}
public double calSalary()
{
	return this.salary;
}
public static void setcompName(String cn)
{
	compName=cn;
}
public static String getcompName()
{
	return compName;
}
public static void setEmployeeCount(int ec)
{
	empCount=ec;
}
public static int getEmployeeCount()
{
	return empCount;
}
}