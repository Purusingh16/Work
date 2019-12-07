package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter
{

	public static void main(String[] args) 
	{
		File inFile=new File("file/FileDemo.txt");
		File writeFile=new File("file/ReadWrite.txt");
		
		FileReader fileReader=null;
		FileWriter fileWriter=null;
		
		try {
			fileReader=new FileReader(inFile);
			
			fileWriter=new FileWriter(writeFile);
			int data;
			while ((data=fileReader.read())!=-1)
			{
				fileWriter.write(data);
				
			}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		
		
	}

}
