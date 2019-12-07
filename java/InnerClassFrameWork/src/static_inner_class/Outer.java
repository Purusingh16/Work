package static_inner_class;

public class Outer 
{
	static String name;
	static int roll;
	
	static class Inner
	{
		void showName(String n)
		{
			name=n;
		}
		static void showRoll(int r)
		{
			roll=r;
		}
	}

	public static void main(String[] args) 
	{
		Inner ii=new Inner();
		ii.showName("purushottam");
//		ii.showRoll(101);
		Inner.showRoll(101);
		System.out.println(Outer.name+"\t"+Outer.roll);
		
	}

}
