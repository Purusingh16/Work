package threading;

public class IManager implements IEmployee,Runnable
{
	private double bonus;
	private int id;
	private String name;
	private double salary;
	
	
	public IManager(int id,String name,double salary,double bonus)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.bonus=bonus;
	}
	@Override
	public String GetEmpInfo() 
	{
		return "info:"+this.id+" "+this.name+" "+this.salary+" "+this.bonus;
	}
	@Override
	public double CalSal() 
	{
		return this.bonus;
	}
	@Override
	public void run() 
	{
		Main.employeeThread("manager !!!!");
	}
}
