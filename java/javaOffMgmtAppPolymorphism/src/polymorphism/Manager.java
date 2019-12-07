package polymorphism;

public class Manager extends Employee
{
	private double bonus;
	
	public Manager(int id,String nm,double sal,double bonus)
	{
		super(id, nm, sal);
		this.bonus=bonus;
	}
	@Override
	public String GetEmpInfo() 
	{
		return super.GetEmpInfo()+" "+bonus;
	}
	@Override
	public double CalSal() 
	{
		return super.CalSal()+(bonus);
	}
}
