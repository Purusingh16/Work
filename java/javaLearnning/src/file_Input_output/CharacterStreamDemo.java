package file_Input_output;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {

	
	public static void main(String[] args) throws IOException {
		FileReader fileReader=null;
		FileReader fileReader1=null;
		FileWriter fileWriter = null;
		try
		{
			fileReader1=new FileReader("files/output.txt");
			fileWriter=new FileWriter("files/output_2.txt");
			
			int data;
			while((data=fileReader1.read()) !=-1)
				
			{
				fileWriter.write(data);
			}
		}catch(FileNotFoundException ex)
		{
		
		ex.printStackTrace();	
		}
		finally
		{
			if(fileReader1 !=null)
				fileReader1.close();
			if(fileWriter !=null)
				fileWriter.close();
		}
	}

}
