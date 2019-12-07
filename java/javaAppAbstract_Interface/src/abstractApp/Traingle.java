package abstractApp;

public class Traingle extends Shape 
{
	private double base;
	private double height;
	
	public Traingle(String name,double base,double height)
	{
		super(name);
		this.base=base;
		this.height=height;
	}
	@Override
	public String getInfo() 
	{
		return super.getInfo()+" "+this.base+" "+this.height;
	}

	@Override
	public double calArea()
	{
		return 0.5*(base*height);
	}

}
