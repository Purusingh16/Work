package javaProject;

public class Person 
{
	private int p_id;
	private String p_name;
	private double p_salary;
	
	public void setpersoninfo(int p_id,String p_name,double p_salary)
	{
		this.p_id=p_id;
		this.p_name=p_name;
		this.p_salary=p_salary;
	}
	public String getpersoninfo()
	{
		return "person info="+this.p_id+" "+this.p_name+" "+this.p_salary;
	}
	public double calSal()
	{
		return this.p_salary;
	}
	public void givebonus(double bonus)
	{
		this.p_salary=this.p_salary+bonus;
	}
}
