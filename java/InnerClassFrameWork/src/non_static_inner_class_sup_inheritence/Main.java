package non_static_inner_class_sup_inheritence;

public class Main 
{
	public static void main(String[] args)
	{
		Outer out=new Outer();
		Outer.Inner2 ii=out.new Inner2();
		ii.setName("Purushottam");
		ii.setRoll(101);
		System.out.println("Name is:"+out.name+"\tRoll number is:"+out.roll);
		 
	}

}
