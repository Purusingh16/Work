package file_Input_output;
import java.io.*;
public class BufferedReaderDemo {

	
	public static void main(String[] args) throws IOException 
	{
		FileReader fr=new FileReader("F:\\java_selenium\\xyz.txt");
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		while(line!=null)
		{
			System.out.println(line);
			line=br.readLine();
		}
		br.close();
	}

}
