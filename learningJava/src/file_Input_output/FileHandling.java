package file_Input_output;

import java.io.*;
import java.util.Scanner;

public class FileHandling {

	
	public static void main(String[] args) throws IOException {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter file name to be created:-");
		String fileName=sc.next();
		File file_2=new File("files/"+fileName);
		file_2.createNewFile();
		
		File directory=new File("files/");
		
		
		System.out.println("directory:- "+directory.isDirectory());
		System.out.println(directory.isFile());
		
//		File file_2=new File("files/test.text");
//		file_2.createNewFile();
		
		String files[]=directory.list();
		
		for(int index=0;index<files.length;index++){
			System.out.println(files[index]);
		}
		
	}

}
