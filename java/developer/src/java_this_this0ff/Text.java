package java_this_this0ff;

public class Text 
{
//	int a=10;
	int a,b;
	
	Text(int a,int b)
	{
		this.a=a;
		this.b=b;
	}
	void m1()
	{
		System.out.println("---dis from m1()---");
		System.out.println("The val of a:"+this.a);
		System.out.println("The val of b:"+this.b);
//		this.m2();//method call
	}
	void m2()
	{
		System.out.println("---dis from m2()---");
		System.out.println("The val of a:"+this.a);
	}
	
	public static void main(String[] args)
	{
		Text text=new Text(10,12);
		text.m1();//method call
		
	}

}
