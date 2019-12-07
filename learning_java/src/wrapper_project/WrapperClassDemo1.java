package wrapper_project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WrapperClassDemo1
{

	public static void main(String[] args) throws IOException 
	{
		FileReader fileReader=new FileReader("file/Assignment.txt");
		
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		
		String line=null;
		while ((line=bufferedReader.readLine())!=null)
		{
				System.out.println(line);
				String[] token=line.split(",");
				for (String t1 : token) 
				{
					System.out.println(t1);
				}
				
		}
	}

}
