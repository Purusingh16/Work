package innerClass;
class Demo1
{
	String name;
	static int roll;
	
	static class Inner
	{
		String getName(String s)
		{
			Demo1 dd=new Demo1();
			dd.name=s;
			return s;
		}
		static int getRoll(int r)
		{
			roll=r;
			return roll;
		}
		
	}
}
public class Test 
{
	public static void main(String[] args)
	{
	
		Demo1.Inner di=new Demo1.Inner();
		System.out.println("Name is:"+di.getName("dipu"));
		System.out.println("Roll number is:"+di.getRoll(101));
	}
		
}


