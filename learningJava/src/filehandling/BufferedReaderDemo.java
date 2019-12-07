package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo 
{

	public static void main(String[] args) throws IOException 
	{
		FileReader fileReader=new FileReader("file/input_1.txt");
		
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		
		String line=null;
		int count=0;
		while ((line=bufferedReader.readLine())!=null)
				{
			count++;
			if(count==1)
				System.out.println(line);
				
			
		}
	}

}
