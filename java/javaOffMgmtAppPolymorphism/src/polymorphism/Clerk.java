package polymorphism;

public class Clerk extends Employee 
{
	private double extraIncome;
	
	public Clerk(int id,String name,double salary,double extraIncome)
	{
		super(id, name, salary);
		this.extraIncome=extraIncome;
	}
	@Override
	public String GetEmpInfo() 
	{
		return super.GetEmpInfo()+" "+extraIncome;
	}
	@Override
	public double CalSal() {
		return super.CalSal()+(extraIncome*10/100);
	}
}
