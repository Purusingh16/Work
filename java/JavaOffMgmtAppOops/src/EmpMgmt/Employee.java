package EmpMgmt;

import java.util.Random;

public class Employee 
{
	private int id;
	private String name;
	private double salary;
	
	private static int empCount;
	private static String compName;
	
	//Static init block - invoked only once
	static
	{
		compName = "IBM";
		empCount = 100;
	}
	
	//Initialization Block - invoked whenever object is created
	{
		Random r = new Random();
		this.id = r.nextInt(100);
		empCount++;
	}
	
	public Employee()
	{
		System.out.println(" Default CTOR called...");
		//this.id=111;
		this.name="Unknown";
		this.salary=5000;
	}
	
	public Employee(int id,String name,double salary)
	{
		System.out.println(" Parameterized CTOR called...");
		//this.id=id;
		this.name=name;
		this.salary=salary;
	}

	public void setEmpInfo(int id,String name,double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
	public String GetEmpInfo()
	{
		return "emp info=" +this.id+" "+this.name+" "+this.salary + " " +compName;
	}

	public double CalSal()
	{
		return this.salary;
	}
	
	public static String GetCompName()
	{
		return compName;
	}
	
	public static void SetCompName(String cn)
	{
		compName = cn;
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

