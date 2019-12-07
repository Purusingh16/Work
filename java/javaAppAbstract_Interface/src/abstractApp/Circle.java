package abstractApp;

public class Circle extends Shape
{
	private double radius;
	public Circle(String name,double radius)
	{
		super(name);
		this.radius=radius;
	}
	
	@Override
	public String getInfo()
	{
		return super.getInfo()+" "+this.radius;
	}
	
	@Override
	public double calArea() 
	{
		return 3.14*radius*radius;
	}

}
