package fileIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileStreamDemo 
{
	public static void main(String[] args) 
	{
		File file=new File("file/FileDemo.txt");
		FileInputStream fileInputStream=null;
		
		try {
			fileInputStream=new FileInputStream(file);
			int data;
			while((data=fileInputStream.read())!=-1)
			{
				System.out.print((char)data);				
			}
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
		

	}

}
