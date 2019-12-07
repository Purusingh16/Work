package modifier;

public  class A 
{
	protected int id;
	protected String name;
	
	
	public A()
	{
		this.id=102;
		this.name="jack";
	}
	public A(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public A(A a)
	{
		this.id=a.id;
		this.name=a.name;
	}
	public void setInfo(int id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public  String getInfo()
	{
		return "information="+this.id+" "+this.name;
	}
	
}
