package wrapperClass;

public class Test
{

	public static void main(String[] args) 
	{
		//Boxing process using Constructers
		Integer obj1=new Integer(123);
		Integer obj2=new Integer("123");
		
		//Boxing process using valueof
		Integer obj3=Integer.valueOf(127);
		Integer obj4=Integer.valueOf("129");
		
		System.out.println("-------After Boxing---------");
		System.out.println("Obj1="+obj1);
		System.out.println("Obj2="+obj2);
		System.out.println("Obj3="+obj3);
		System.out.println("Obj4="+obj4);
		
		//unBoxing process
		int a=obj1.intValue();
		String s1=obj2.toString();
		
		int b=obj3.intValue();
		String s2=obj4.toString();
		
		System.out.println("-------After unBoxing---------");
		System.out.println("a="+a);
		System.out.println("s1="+s1);
		System.out.println("b="+b);
		System.out.println("s2="+s2);
	}

}
