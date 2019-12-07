package project;

public class FullTime extends Employee 
	{
 private double extraIncome;
 private String designation;

 public FullTime()
 {
	 super();
	 this.designation="manager";
	 this.extraIncome=30;
 }
 public FullTime(String name,int age,char gender,double salary,String designation,double extraIncome)
 {
	 super(name,age,gender,salary);
	 this.extraIncome=extraIncome;
	 this.designation=designation;
 }
 
 @Override
 public String getEmpInfo() 
 	{
		return super.getEmpInfo()+" "+extraIncome+" "+designation;
	}
@Override
public double calSalary() 
{
		return super.calSalary()+(extraIncome*10/100);
	} 
}