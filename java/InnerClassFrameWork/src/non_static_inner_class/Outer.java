package non_static_inner_class;

public class Outer 
{
	String name;
	int roll;
	
	private class Inner
	{
		void setName(String name)
		{
			Outer.this.name=name;
		}
		void setRoll(int r)
		{
			Outer.this.roll=r;
		}
		String getName()
		{
			return name;
		}
		int  getRoll()
		{
			return roll;
		}
		void display()
		{
			Inner ii=new Inner();
			ii.setName("Purushottam");
			ii.setRoll(101);
			
			System.out.println("Name is:"+ii.getName()+"\tRoll number is:"+ii.getRoll());
			
		}
	}
	public static void main(String[] args)
	{
		Outer oo=new Outer();
		Outer.Inner in=oo.new Inner();
//		Outer.Inner in=new Outer().new Inner();
		in.display();
		System.out.println(oo.name+"\t"+oo.roll);
//		System.out.println(in.name+"\t"+in.roll);

	}
	

}
