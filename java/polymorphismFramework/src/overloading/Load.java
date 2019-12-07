package overloading;

public class Load 
{
	public void add(int a,int b)
	{
		System.out.println("Addition is:"+(a+b));
	}
	void add(String s1,String s2)
	{
		System.out.println("Message is:"+(s1+s2));
	}
	public void add(short s1,short s2)
	{
		System.out.println("Sum is:"+(s1+s2));
	}
	public static void main(String[] args) 
	{
		Load ll=new Load();
		byte b1=10,b2=20;
		ll.add(b1, b2);
		ll.add("learn", "java");
	}

}
