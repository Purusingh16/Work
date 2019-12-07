package innerClass;

class Outer
{
	class Inner
	{
		public void m1()
		{
			System.out.println("Inner class method");
		}
	}

	public static void main(String[] args) 
	{
		Outer o1=new Outer();
		Outer.Inner oi=o1.new Inner();
		oi.m1();
//		Outer.Inner oi1=new Outer().new Inner();

	}

}
