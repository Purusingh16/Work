package project;

public class Teacher extends Person 
{
	private int hour_rate=100;
	private int per_day=8;
	
	public Teacher(int id,String name,int attendence)
	{
		super(id, name, attendence);
	}
	
	@Override
	public String getPersonInfo() 
	{
		return super.getPersonInfo();
	}
	
	public int calSalary()
	{
		return getAttendence()*hour_rate*per_day;
	}

}
