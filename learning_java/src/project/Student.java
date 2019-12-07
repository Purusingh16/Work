package project;

public class Student extends Person
{
	private int per_month_fees=100;
	
	public Student(int id,String name,int attendence)
	{
		super(id, name, attendence);
		
	}
	
	@Override
	public String getPersonInfo() 
	{
		return super.getPersonInfo();
	}
	
	public int  payFees()
	{
		 int month=getAttendence()/30;
		 return month*per_month_fees;
	}
	
}
