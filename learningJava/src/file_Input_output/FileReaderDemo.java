package file_Input_output;
import java.io.*;
public class FileReaderDemo {

	
	public static void main(String[] args) throws IOException
	{
		File f=new File("F:\\java_selenium\\abc.txt");
		FileReader fr=new FileReader(f);
		char[] ch=new char[(int)f.length()];
		fr.read(ch);
		
		for(char ch1:ch)
		{
			System.out.print(ch1);
		}
		System.out.println("*********************");
		FileReader fr1=new FileReader(f);
		int i=fr1.read();
		while(i!=-1)
		{
			System.out.print((char)i);
			i=fr1.read();
		}

	}

}
