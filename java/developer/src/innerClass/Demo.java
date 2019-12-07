package innerClass;

public class Demo 
{
	String name;
	String add;
	static int roll;
	
	private String getName(String s)
	{
		name=s;
		return "info:"+name;
	}
	static int getRoll(int r)
	{
		roll=r;
		return roll;
	}
	private static class inner
	{
		String getAddress(String a)
		{
			Demo dd=new Demo();
			dd.add=a;
			return dd.add;
		}
		void display()
		{
			Demo dd=new Demo();
			System.out.println("Name is:"+dd.getName("Dpu"));
			System.out.println("Roll is:"+dd.getRoll(101));
			System.out.println("Address is:"+dd.add);
		}
	}
	public static void main(String[] args)
	{
		inner ii=new inner();
		ii.display();
	}

}
