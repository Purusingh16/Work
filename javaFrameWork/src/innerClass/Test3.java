package innerClass;

public class Test3 
{
	int x=10;
	static int y=20;
	public static void m1()
	{
		class Inner
		{
			public void m2()
			{
//				System.out.println(x);//compile time error because instance variable cannot access
				System.out.println(y);
			}
			/*public void sum(int x,int y)
			{
				System.out.println("the sum:"+(x+y));
			}*/
		}
		Inner i=new Inner();
		i.m2();
		/*i.sum(10, 20);
		i.sum(20, 20);
		i.sum(100, 100);*/
	}

	public static void main(String[] args) 
	{
		Test3 t1=new Test3();
		t1.m1();
		
	}

}
