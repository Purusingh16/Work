package exceptionTest;

import java.io.*;

public class Test1 {

	
	public static void main(String[] args) throws FileNotFoundException 
	{
		PrintWriter pw=new PrintWriter("abc.txt");
		pw.println("Hello");
		System.out.println(10/0);
	}

}
