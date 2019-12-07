package exceptionTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestException {
	
	public static void main(String[] args) throws FileNotFoundException{
		callDivide();
	}
	public static void callDivide() throws FileNotFoundException{
		try{
			
		
		divide(12,0);
		}catch(java.lang.ArithmeticException e)
		{
			System.out.println("exception caught in callDivide method");
		}
	}
	
	public static void divide(int a,int b)throws java.lang.ArithmeticException, FileNotFoundException{
	if(b==0)
	{
		throw new RuntimeException();
	}
		System.out.println(a/b);
		File file=new File("abc.txt");
		FileInputStream inp=new FileInputStream(file); 
//		throw new RuntimeException();
	}
	
	}
