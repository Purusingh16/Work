package polymorphism;

public class Engineer extends Employee
{
	private double extrahrs;
	private double incentive;
	
	public Engineer(int id,String nm,double sal,double extrahrs,double incentive)
	{
		super(id, nm, sal);
		this.extrahrs=extrahrs;
		this.incentive=incentive;
	}
	
	@Override
	public String GetEmpInfo() 
	{
		return super.GetEmpInfo()+" "+extrahrs+" "+" "+incentive;
	}
	@Override
	public double CalSal() 
	{
		return super.CalSal()+(extrahrs*incentive);
	}
}
