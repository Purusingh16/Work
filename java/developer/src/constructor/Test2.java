package constructor;

public class Test2
{
	String name;
	int roll;
	
	Test2()
	{
		System.out.println("learn java");
	}
	Test2(String s)
	{
		name=s;
	}
	Test2(String name,int roll)//constructor overloading String type and int type
	{
		this.name=name;
		this.roll=roll;
	}
	public static void main(String[] args)
	{
		Test2 tt=new Test2();
		System.out.println(tt.name+"\t"+tt.roll);
		
		Test2 tt1=new Test2("dipu");
		System.out.println(tt1.name+"\t"+tt1.roll);
		
		Test2 tt2=new Test2("dipu sing",101);
		System.out.println(tt2.name+"\t"+tt2.roll);
		
		
	}

}
