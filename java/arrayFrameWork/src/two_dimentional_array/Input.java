package two_dimentional_array;

import java.io.DataInputStream;
import java.io.IOException;

public class Input
{
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		DataInputStream dis=new DataInputStream(System.in);
		System.out.println("Enter the size of the row");
		int r=Integer.parseInt(dis.readLine());
		System.out.println("Enter number of column");
		int c=Integer.parseInt(dis.readLine());
		int arr[][];
		arr=new int[r][c];
		System.out.println("\nInitialize array elements");
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				arr[i][j]=Integer.parseInt(dis.readLine());
			}
			
		}
		System.out.println("\nsee the element.\n");
		for (int i = 0; i  < r; i++)
		{
			for (int j = 0; j < c; j++)
			{
				System.out.println(arr[i][j]+"\t");
			}
			
		}
		System.out.println("\n"+arr[1][0]);
	}

}
