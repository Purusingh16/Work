package innerClass;

public class Outer2 
{
	int x=10;
//	static int y=20;
	class Inner
	{
		int x=100;
		public void m1()
		{
			int x=1000;
			System.out.println("inner method data:"+x);
			System.out.println("inner data:"+Inner.this.x);
			System.out.println("outer data:"+Outer2.this.x);
//			System.out.println("outer static data member:"+y);
		}
		
	}

	public static void main(String[] args) 
	{
		Outer2 out=new Outer2();
		Outer2.Inner oi=out.new Inner();
		oi.m1();
		
	}

}
