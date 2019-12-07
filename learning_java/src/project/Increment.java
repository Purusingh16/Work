package project;

public class Increment {

	public static void main(String[] args)
	{
		int index=0;
		
		int a=index++;
		int b=++index;
		
		int c=index++ + ++index;
		int d=index-- - --index;
		
		System.out.println(index);
		System.out.println(a);
		System.out.println(b);
		
		System.out.println(c);
		System.out.println(d);
	}

}
