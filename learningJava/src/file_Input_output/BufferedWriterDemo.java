package file_Input_output;
import java.io.*;
public class BufferedWriterDemo {

	
	public static void main(String[] args)throws IOException
	{
//		File f=new File("F:\\java_selenium\\abc.txt");
		FileWriter fw=new FileWriter("F:\\java_selenium\\xyz.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(100);//adding a single character
//		bw.newLine();
		bw.write("ipu");
		bw.newLine();
		char[] ch1={'s','i','n','g','h'};
		bw.write(ch1);
		bw.newLine();
		bw.write("selenium");
		bw.newLine();
		bw.write("class");
		bw.flush();
		bw.close();
	}

}
