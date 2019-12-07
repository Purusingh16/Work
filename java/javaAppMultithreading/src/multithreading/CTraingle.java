package multithreading;

public class CTraingle implements IShape, Runnable
{
	private String name;
	private double base;
	private double height;
	
	public CTraingle(String name,double base,double height)
	{
		this.base=base;
		this.height=height;
		this.name=name;
	}

	@Override
	public double CalArea() 
	{
		return 0.5*(base*height);
	}

	@Override
	public String GetInfo() 
	{
		return "info="+this.base+" "+this.height+" "+this.name;
	}

	@Override
	public void run() 	
	{
		Main.ShapeThread("TRIANGLE !!!");
		
	}

}
