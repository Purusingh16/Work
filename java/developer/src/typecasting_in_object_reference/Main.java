package typecasting_in_object_reference;

public class Main 
{
	int i;
	public static void main(String[] args)
	{
		Main mm=new Main();
		mm.i+=10;
		
		Main mm1=new Main();
		mm1.i++;
		System.out.println(mm1.i);
		
	}
	public static void main3(String[] args)
	{
		byte a=10;
		byte b=2;
		a*=b;
		System.out.println(a);
		
	}
	public static void main2(String[] args)
	{
		byte b=10;
		byte c=20;
		byte a=(byte) (b%c);
		System.out.println(a);
	}
	public static void main1(String[] args)
	{
		boolean b=true;
		if(!b)
		{
			System.out.println("c application");
		}
		else if(b)
		{
			System.out.println("java application");
		}
		else
		{
			System.out.println("not application");
		}
	}
	public static void main0(String[] args) 
	{
		B ab=new B();
		ab.increment();
		A aa;
		aa=ab;//auto conversion of object reference
		
		System.out.println(ab.i+"\t"+ab.j);
		System.out.println(aa.i);
		
		B bb;
		bb=(B)aa;//type casting of object reference
		
		System.out.println(bb.i+"\t"+bb.j);
	}

}
