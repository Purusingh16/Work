package multithreading;

public class CSquire implements IShape, Runnable
{
	private String name;
	private double side;
	
	public CSquire(String name,double side)
	{
		this.name=name;
		this.side=side;
			
	}

	@Override
	public double CalArea()
	{
		return side*side;
	}

	@Override
	public String GetInfo() 
	{
		return "info="+this.name+" "+this.side;
	}

	@Override
	public void run() 
	{
		Main.ShapeThread("SQUARE ...");
		
	}

}
