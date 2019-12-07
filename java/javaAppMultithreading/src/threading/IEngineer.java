package threading;

public class IEngineer implements IEmployee,Runnable
{
	private double extrahrs;
	private double incentive;
	private int id;
	private String name;
	private double salary;
	
	public IEngineer(int id,double extrahrs,double incentive, String name, double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
		this.extrahrs=extrahrs;
		this.incentive=incentive;
	}
	@Override
	public String GetEmpInfo()
	{
		return "info:"+this.id+" "+this.name+" "+this.salary+" "+this.extrahrs+" "+this.incentive;
	}
	@Override
	public double CalSal() 
	{
		return extrahrs*incentive;
	}
	@Override
	public void run() 
	{
		Main.employeeThread("Engineer !!!");
	}
}
