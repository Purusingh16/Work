package scanner;

public class DemoConstructor 
{
	int a;
	int b;
	//default constructor
	public DemoConstructor()
	{
		a=11;
		b=12;
	}
	//parameterize constructor
	public DemoConstructor(int first,int second)
	{
		this.a=first;
		this.b=second;
	}
	//method with same name as class but it is not a constructor
	public void DemoConstructor(int first,int second)
	{
		this.a=first;
		this.b=second;
	}
	public void setFirst(int first)
	{
		this.a=first;
	}
	public void setSecond(int second)
	{
		this.b=second;
	}
	public int getFirst()
	{
		return this.a;
	}

}
