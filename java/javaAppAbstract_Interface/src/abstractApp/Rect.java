package abstractApp;

public class Rect extends Shape
{
	private double length;
	private double breath;
	
	public Rect(String name,double length,double breath) 
	{
		super(name);
		this.breath=breath;
		this.length=length;
	}
	@Override
	public String getInfo() 
	{
		return super.getInfo()+" "+this.breath+" "+this.length;
	}
	@Override
	public double calArea() 
	{
		return length*breath;
	}
	
	
	
	

}
