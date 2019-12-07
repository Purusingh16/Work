package file_Input_output;

import java.io.*;
public class FileWriterDemo

{
	public static void main(String[] args)throws IOException  
	{
		FileWriter fw=new FileWriter("F:\\java_selenium\\abc.txt",true);
		fw.write(100);//adding a single character
		fw.write("ipu\nSeleniumClass");
		fw.write('\n');
		char[] ch1={'s','i','n','g','h'};
		fw.write(ch1);
		fw.write('\n');
		fw.flush();
		fw.close();
	}

}
