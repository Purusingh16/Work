package excelFile;


import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Test
{

	public static void main(String[] args)throws Exception
	{
CSVReader reader=new CSVReader(new FileReader("files//file.csv"));
		
		List<String[]> li=reader.readAll();
		System.out.println("Total rows which we have is "+li.size());
		
Iterator<String[]>i1= li.iterator();
		
		while (i1.hasNext()) {
			
			String[] str=i1.next();
			
			System.out.print(" Values are "+ str[0]);
			
			for(int i=0;i<str.length;i++)
			{

				System.out.print(" "+str[i]);
			

			}
			System.out.println(" ");
			
		}

	}

	
}


