package polymorphism;

public class OverloadAdd 
{
	public void add(int a,int b)
	{
		System.out.println("Adition is:"+(a+b));
	}
	void add(double d,double e)
	{
		System.out.println("Value is:"+(d+e));
	}
	static void add(String s1,String s2)
	{
		System.out.println("Value is:"+(s1+s2));
	}
	void add(short a,short b)
	{
		System.out.println("Sum is:"+(a+b));
	}
	public static void main(String[] args) 
	{
		OverloadAdd overAdd=new OverloadAdd();
		byte b=10,c=20;
		overAdd.add(b, c);
		overAdd.add(10.38, 30.45);
		overAdd.add(50, 50);
		overAdd.add("I Like", "java");
		

	}

}
