package exceptionTest;
import java.io.*;
public class Test12 
{
	public static void main(String[] args)
	{
//		throw new Exception(); checked:compile time
//		throw new Error();unchecked:run time
		try
		{
			System.out.println("Hello");
		}
//		catch(ArithmeticException e)
//		catch(Exception e)
//		catch( IOException e)
//		catch(InterruptedException e)
		catch(Error e)
		{
			
		}
	}
}
