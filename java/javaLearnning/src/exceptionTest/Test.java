package exceptionTest;

public class Test {

	
	public static void main(String[] args) {
		doStuff();
		System.out.println(10/0);
	}
	public static void doStuff()
	{
		doMoreStuff();
//		System.out.println(10/0);
		System.out.println("Hello");
	}
	public static void doMoreStuff()
	{
		
//		System.out.println(10/0);
		System.out.println("Hello");
	}

}










