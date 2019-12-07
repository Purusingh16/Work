package wrapper_project;

public class Demo 
{
	byte a=10;
	byte b=20;
	 
	int c=(byte)(a+b);

	public static void main(String[] args) 
	{
		Demo d=new Demo();
		System.out.println("result:"+d.c);
	
	}

}
