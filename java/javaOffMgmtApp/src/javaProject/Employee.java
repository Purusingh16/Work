package javaProject;

public class Employee 
{
	private int id;
	private String name;
	private double salary;

	public void setEmpInfo(int id,String name,double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
	public String GetEmpInfo()
	{
		return "emp info=" +this.id+" "+this.name+" "+this.salary;
	}

	public double CalSal()
	{
		return this.salary;
	}
	
	public void GiveBonus(double bonus)
	{
		this.salary=this.salary+bonus;
	}
}
