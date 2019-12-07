package innerClass;

class A
{
	class B
	{
		class C
		{
			public void m1()
			{
				System.out.println("Inner most class method");
			}
		}
	}
}
public class Test2 
{
	public static void main(String[] args)
	{
		A a=new A();
		A.B ab=a.new B();
		A.B.C  abc=ab.new C();
		abc.m1();
		
	}

}
