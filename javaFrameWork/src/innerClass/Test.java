package innerClass;
class Outer3
{
	class Inner
	{
		public void m1()
		{
			System.out.println("Inner class method");
		}
	}
}

public class Test
{
	public static void main(String[] args) 
	{
		Outer2 o=new Outer2();
		Outer2.Inner oi=o.new Inner();
		oi.m1();

	}

}
