package constructor;

public class Test1 
{
	String name;
	Test1()
	{
//		System.out.println("learn java");
	}
	Test1(String n)
	{
		name=n;
	}
	public static void main(String[] args)
	{
		Test1 tt1=new Test1();
		System.out.println(tt1.name);
		
		Test1 tt2=new Test1("java");
		System.out.println(tt2.name);
	}

}
