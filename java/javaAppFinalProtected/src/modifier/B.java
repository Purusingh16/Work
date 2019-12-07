package modifier;

public class B extends A 
{
	private double salary;
	
	public B()
	{
		//super();
		this.id = 111;
		this.name = "xyz";
		this.salary=4003.46;
	}
	public B(int id,String name,double salary)
	{
		//super(id,name);
		this.id =  id;
		this.name = name;
		this.salary=salary;
	}
	public B(B b)
	{
		super(b);
		this.salary=b.salary;
	}
	@Override
	public String getInfo()
	{
		return super.getInfo()+" "+salary;
	}

	
}
