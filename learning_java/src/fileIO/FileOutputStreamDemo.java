package fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo
{

	public static void main(String[] args)
	{
		File inFile=new File("file/FileIODemo1.txt");
		File outFile=new File("file/FileIOOutput1.txt");
		
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
		
		try
		{
			fileInputStream=new FileInputStream(inFile);
			fileOutputStream=new FileOutputStream(outFile);
			
			int data;
			while ((data=fileInputStream.read())!=-1) 
			{
				fileOutputStream.write(data);
				
			}
			{
				System.out.println("File is created");
			}
			fileInputStream.close();
			fileOutputStream.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	
	}

}
