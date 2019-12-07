package filehandling;

import java.io.File;
import java.io.IOException;

public class FileDemo 
{

	public static void main(String[] args) 
	{
		File file=new File("Files/FileIODemo2.txt");
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
		//	file.delete();
		}

	}
}
