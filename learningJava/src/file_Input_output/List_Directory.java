package file_Input_output;

import java.io.*;

public class List_Directory {

	
	public static void main(String[] args) 
	{
		int count=0;
		File f=new File("F:\\java_selenium");
		String[] s=f.list();
		
		for(String s1:s)
		{
			count++;
			System.out.println(s1);
		}
		System.out.println("the total number:"+count);
	}

}
