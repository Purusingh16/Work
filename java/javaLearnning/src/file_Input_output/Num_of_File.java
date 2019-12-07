package file_Input_output;
import java.io.*;
public class Num_of_File 
{

	
	public static void main(String[] args)
	{
		int count=0;
		File f=new File("F:\\java_selenium");
		String[] s=f.list();
		
		for(String s1:s)
		{
			File f1=new File(f,s1);
			
//			if(f1.isFile())
			if(f1.isDirectory())	
			{
				count++;
				System.out.println(s1);
			}
			
		}
		System.out.println("the total number of directory:"+count++);
//		System.out.println("the total number of file:"+count++);
		

	}

}
