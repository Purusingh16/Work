package file_Input_output;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteSteamDemo {

	
	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream=null;
		FileOutputStream fileOutputStream=null;
		
		try
		
		{
//			File file=new File("files/source.txt");
			int data;
			fileInputStream=new FileInputStream("files/selenium.txt");
			fileOutputStream=new FileOutputStream("files/output.txt",true);
			
			while((data=fileInputStream.read())!=-1)
			{
				System.out.println(" "+data);
				fileOutputStream.write(data);
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(fileInputStream !=null)
				fileInputStream.close();
			if(fileOutputStream !=null)
				fileOutputStream.close();
		}
		
	}

}
