package exceptionTest;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Test6 {

	
	public static void main(String[] args) throws FileNotFoundException
	{
		PrintWriter pw=new PrintWriter("abc.txt");
		pw.println("Hello");
		
	}

}
