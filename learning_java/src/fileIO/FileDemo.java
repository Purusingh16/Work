package fileIO;

import java.io.File;
import java.io.IOException;

public class FileDemo 
{

	public static void main(String[] args) 
	{
		File file=new File("file/FileDemo.txt");
		
		try 
		{												
			boolean isCreated=file.createNewFile();
			System.out.println(isCreated);
		} 
		
			catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		
		if(file.isDirectory())
		{
			System.out.println("File reference represent a Directory");
		}
		
		else
		{
			System.out.println("File reference represents a file");
		}

	}

}
