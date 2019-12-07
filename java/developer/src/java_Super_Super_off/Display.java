package java_Super_Super_off;

public class Display extends Test 
{
	int a=20;
	
	Display(int y)
	{
		super(y);//super class const call
		System.out.println("...Display cons dis...");
		System.out.println("The value of y:"+y);
		
	}
	void dis()
	{
		super.dis();//super class method call
		System.out.println("...Child class...");
		System.out.println("The val of a:"+a);
	}

}
