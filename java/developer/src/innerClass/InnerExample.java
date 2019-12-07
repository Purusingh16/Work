package innerClass;
class Outer
{
	static int x;
	protected class Inner
//	static class Inner//this class not access the member of outter class
	{
		void if1()
		{
			System.out.println("if1"+x);
		}
		
	}
}
public class InnerExample
{
	public static void main(String[] args) 
	{
		Outer out=new Outer();
		Outer.Inner o1=out.new Inner();
//		Outer.Inner o1=new Outer.Inner();
		o1.if1();
	}

}
