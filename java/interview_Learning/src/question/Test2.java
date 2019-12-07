package question;

public class Test2 
{
	static int a=1111;
	static 
	{
		a=a-- - --a;
	}
	{
		a=a++ + ++a;
	}
	public static void main(String[] args) 
	{
		System.out.println(a);
	}

}
