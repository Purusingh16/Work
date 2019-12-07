package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo
{

	public static void main(String[] args) 
	{
		File file=new File("file/FileDemo.txt");
		FileReader fileReader=null;
		
		try 
		{
			fileReader=new FileReader(file);
			int data;
			
			try 
			{
				while ((data=fileReader.read())!=-1) 
				{
					System.out.print((char)data);
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

	}

}
