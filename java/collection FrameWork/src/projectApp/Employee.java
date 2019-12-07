package projectApp;

public class Employee 
{
	private int id;
	private String name;
	private double salary;
		
	public Employee(int id,String name,double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public String getEmployeeInfo()
	{
		return "info:"+this.id+" "+this.name+" "+this.salary;
	}

}
