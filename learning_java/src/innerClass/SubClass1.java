package innerClass;

public class SubClass1 
{
		int a=10;
		static int b=20;
		static class SubClass2
		{
			static void m1(SubClass1 x)
			{
				System.out.println("----display from m1()---");
				
				System.out.println("The value of a:"+x.a);
				System.out.println("The value of b:"+b);
			}
			void m2(SubClass1 x)
			{
				System.out.println("----display from m2()---");
				System.out.println("The value of a:"+x.a);
				System.out.println("The value of b:"+b);
			}
		}//end of inner class
		SubClass2 obj2=new SubClass2();
}//end of outer class




