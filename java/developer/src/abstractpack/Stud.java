package abstractpack;

abstract class Stud 
{
	public  final String name;
	public final int roll;
	
	public Stud(String n,int r)
	{
		name=n;
		roll=r;
	}
	public abstract String getName();
	public abstract int getRoll();
	
	void display()
	{
		System.out.println("Demo of abstract class");
	}

}
