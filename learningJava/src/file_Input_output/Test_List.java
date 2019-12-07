package file_Input_output;
import java.io.*;
public class Test_List 
{

	
	public static void main(String[] args) throws Exception 
	{
		int count=0;
		File f=new File("file");
		String[] s=f.list();
		
		for(String s1:s)
		{
			File f1=new File(f,s1);
			if(f1.isFile())
			{
			count++;
			System.out.println(s1);
			}
		}
		System.out.println("the total number:"+count);
		
	}

}
