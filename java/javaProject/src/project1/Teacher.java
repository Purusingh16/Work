package project1;

class Teacher extends Person 
{
	private double salary;
//	private String[] subject;
	
	public Teacher(String name,int age,double salary)
	{
		super(name, age);
		this.salary=salary;
		
	}
@Override
public String getpersonInfo() 
{
	return super.getpersonInfo()+" "+this.salary;
} 
	
	 
}
