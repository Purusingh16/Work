package java_this_this0ff;

public class Test
{
	
	Test(int x,int y,int z)
	{
		this(x,y);//const call
		System.out.println("The value of z:"+z);
	}
	Test(int x,int y)
	{
		this(x);//const call
		System.out.println("The value of y:"+y);
	}
	Test(int x)
	{
		System.out.println("The value of x:"+x);
	}
	
	public static void main(String[] args) 
	{
		Test t1=new Test(12,13,14);
	}

}
