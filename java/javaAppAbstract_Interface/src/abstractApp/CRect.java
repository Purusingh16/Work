package abstractApp;

public class CRect implements IShape, Runnable
{
	private String name;
	private double length;
	private double breadth;
	
	public CRect(String name,double length,double breadth)
	{
		this.breadth=breadth;
		this.length=length;
		this.name=name;
	}
	
	@Override
	public double CalArea() 
	{
		return length*breadth;
	}

	@Override
	public String GetInfo() 
	{
		return "info="+this.breadth+" "+this.length+" "+this.name;
	}

	@Override
	public void run() 
	{
		
	}

}
