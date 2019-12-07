package question;

public class Test1 
{
	public static void show()//undefined method
	{
		System.out.println("Static method called");
	}
	public static void main(String[] args) 
	{
		Test1 test=null;
		Test1.show();
	}

}
