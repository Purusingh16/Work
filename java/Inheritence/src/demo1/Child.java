package demo1;

public class Child extends Base
{
	String add;
	int roll;
	
	Child()
	{
		System.out.println("child class");
	}
	Child(String add,int roll)
	{
		super("Purushottam");
		this.roll=roll;
		this.add=add;
	}
	/*Child(int roll)
	{
		super("Purushottam");
		this.roll=roll;
	}*/
	void display()
	{
		System.out.println("Name is:"+name+"\tRoll number is:"+roll+"\tAddress is:"+add);
	}

}
