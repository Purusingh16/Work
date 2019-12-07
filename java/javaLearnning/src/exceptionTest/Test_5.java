package exceptionTest;

public class Test_5 {

	
	public static void main(String[] args) 
	{
		System.out.println(10/0);
		throw new ArithmeticException("/ by zero");
//		System.out.println("Hello");unreachable statement
	}

}
