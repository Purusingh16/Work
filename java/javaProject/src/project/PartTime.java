package project;

class PartTime extends Employee
{
private int working_hours;
private int rate_per_hours;

public PartTime()
{
	super();
	this.working_hours=6;
	this.rate_per_hours=200;
	
}
public PartTime(String name,int age,char gender,double salary,int working_hours,int rate_per_hours)
{
	super(name,age,gender,salary);
	this.working_hours=working_hours;
	this.rate_per_hours=rate_per_hours;
}
@Override
public String getEmpInfo()
	{
		return super.getEmpInfo()+" "+working_hours+" "+rate_per_hours;
	}
@Override
public double calSalary()
	{
		return super.calSalary()+(working_hours*rate_per_hours);
	}
}