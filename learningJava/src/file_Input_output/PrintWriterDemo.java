package file_Input_output;
import java.io.*;
public class PrintWriterDemo {

	
	public static void main(String[] args) throws IOException
	{
		FileWriter fw=new FileWriter("F:\\java_selenium\\xyz.txt");
		PrintWriter out=new PrintWriter(fw);
		out.write(100);
		out.println(100);
		out.println(true);
		out.println('c');
		out.println("durga");
		out.flush();
		out.close();
		
		
	}

}
