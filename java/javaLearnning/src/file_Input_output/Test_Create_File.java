package file_Input_output;
import java.io.*;
public class Test_Create_File 
{

	public static void main(String[] args) throws Exception
	{
		File f=new File("F:\\java_selenium\\");
//		File f=new File("Program");
		System.out.println(f.exists());
		f.mkdir();
//		f.createNewFile();
	 	System.out.println(f.exists());
		
	}

}
