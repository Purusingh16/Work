package polymorphism;

public class Demo 
{
	public static void main(String[] args) 
	{
		Object obj=new X1(1000);
		System.out.println(obj);
		
		Object obj1=new Y1(100);
		System.out.println(obj1);
		
	}
	public static void main1(String[] args) 
	{
		X p1=new Y();
		System.out.println(p1.i);
	}

}
