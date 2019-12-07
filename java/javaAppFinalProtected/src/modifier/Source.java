package modifier;

public class Source 
{
	public static void main(String[] args)
	{
		
		A a1=new A(101,"tom");
		System.out.println(a1.getInfo());
		
		A a2=new A(a1);
		System.out.println(a2.getInfo());
		
		A a3=new A();
		System.out.println(a3.getInfo());
		
		B b1=new B(501,"tom",4998.47);
		System.out.println(b1.getInfo());
		
		B b2=new B();
		System.out.println(b2.getInfo());
		
		B b3=new B(b1);
		System.out.println(b3.getInfo());
		
		
	}

}
