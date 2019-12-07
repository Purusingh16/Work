package innerClass;

public class Outer1 
{
	class Inner
	{
		public void m1()
		{
			System.out.println("Inner class method");
		}
	}
	public void m2()
	{
		Inner i=new Inner();
		i.m1();
		System.out.println("Outer class method");
		
	}

	public static void main(String[] args) 
	{
		Outer1 o=new Outer1();
		o.m2();
	}

}
