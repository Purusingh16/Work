package array_of_object_reference;

import java.io.DataInputStream;
import java.io.IOException;

public class Text 
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("Enter the number of Student information you store");
		int size=Integer.parseInt(dis.readLine());
		Stud ss[]=new Stud[size];
		System.out.println("Enter Student info");
		for (int i = 0; i < size; i++)
		{
			System.out.println("Enter information for"+(i+1)+" Student information");
			ss[i]=new Stud();
			System.out.println("Enter name of "+(i+1)+"Student");
			ss[i].name=dis.readLine();
			
			System.out.println("Enter roll number of"+(i+1)+"Student");
			ss[i].roll=Integer.parseInt(dis.readLine());
		}
		System.out.println("\nsee the student information.\n");
		for (int i = 0; i < size; i++)
		{
			System.out.println("Name is:"+ss[i].name+"\tRoll number is:"+ss[i]);
			
		}
	}

}
