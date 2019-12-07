package polymorphism1;

public class Main 
{
	public static void main(String[] args)
	{
		Base1 b;
		b=new Child1();
		
		int sum=b.increment();
		System.out.println("Value is:"+sum);
	}
	public static void main1(String[] args) 
	{
		Child ch=new Child();
		ch.i++;
		ch.increment();
		System.out.println(ch.i++);
		
	}

}
