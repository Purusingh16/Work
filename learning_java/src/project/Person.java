package project;

public class Person 
{
	private int id;
	private String name;
	private int attendence;
	
	public Person(int id,String name,int attendence )
	{
		this.id=id;
		this.name=name;
		this.attendence=attendence;
	}
	
	public void setPersonInfo(int id,String name,int attendence)
	{
		this.id=id;
		this.name=name;
		this.attendence=attendence;
	}
	
	public String getPersonInfo()
	{
		return "information:"+this.id+" "+this.name+" "+this.attendence;
	}
	public int getAttendence()
	{
		return this.attendence;
		
	}
	
	
}
