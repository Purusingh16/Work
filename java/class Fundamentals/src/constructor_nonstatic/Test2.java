package constructor_nonstatic;

public class Test2
{
	String name;
	int roll;
	
	public Test2()
	{
		System.out.println("object is constructed");
	}
	public Test2(String name)
	{
		this();
		this.name=name;
	}
	public Test2(int roll)
	{
		this("Dipu");
		this.roll=roll;
	}
	public String getName()
	{
		return name;
	}
	public int getRoll()
	{
		return roll;
	}
	public static void main(String[] args)
	{
		Test2 tt=new Test2(101);
		System.out.println("Name is:"+tt.getName()+"\tRoll number is:"+tt.getRoll());
	}

}
