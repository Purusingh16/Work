package scanner_class;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Input
{
	public static void main(String[] args) throws IOException 
	{
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("Enter your name");
		String name=dis.readLine();
		System.out.println("Enter your roll number");
		int roll_num=Integer.parseInt(dis.readLine());
		System.out.println("Enter your fee");
		double fee=Double.parseDouble(dis.readLine());
		
		System.out.println("Name is:"+name+"\tRoll number is:"+roll_num+"\tfee is:"+fee);
	}
	public static void main0(String[] args) 
	{
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter your name");
		String name=ss.nextLine();
		System.out.println("Enter your roll number");
		int roll_number=ss.nextInt();
		System.out.println("Enter your fee");
		double fee=ss.nextDouble();
		
		System.out.println("Name is:"+name+"\tRoll number is:"+roll_number+"\tfee is:"+fee);
	}

}
