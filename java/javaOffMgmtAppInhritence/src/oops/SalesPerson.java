package oops;

public class SalesPerson extends Employee
{
	  private int sales;
	  private double comm;
	  
	  public SalesPerson(int id, String nm, double sal, int sls, double com)
	  {
		  super(id, nm, sal);
		  this.sales = sls;
		  this.comm = com;
	  }
	  
	  @Override
	  public String GetEmpInfo() 
	  {
			return super.GetEmpInfo()+ " " +sales  + " " + comm;
	  }
	  
	  @Override
	public double CalSal() 
	{
		return super.CalSal() + (sales*comm);
	}
}
