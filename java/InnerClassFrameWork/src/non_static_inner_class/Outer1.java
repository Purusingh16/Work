package non_static_inner_class;
//how we create object of non-static inner class within main?
public class Outer1 
{
	int data;
	class Inner
	{
		void increament()
		{
			data++;
		}
	}
	public static void main(String[] args)
	{
		Outer1 out=new Outer1();
		Inner ii=out.new Inner();
		ii.increament();
		System.out.println("Value is :"+out.data);
	}

}
