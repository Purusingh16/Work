package abstractApp;

public abstract class Shape 
{
	private String name;
	
	public Shape(String name)
	{
		this.name=name;
	}
	public String getInfo()
	{
		return "info="+this.name;
	}
	/*public double calArea()
	{
		return 0;
	}*/
	public abstract double calArea();
}
