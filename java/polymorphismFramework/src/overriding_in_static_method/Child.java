package overriding_in_static_method;

public class Child extends Base 
{
	public static void showMessage(String msg)
	{
		System.out.println("Data is:"+msg);
	}

}
