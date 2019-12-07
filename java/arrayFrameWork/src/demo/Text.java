package demo;

public class Text 
{

	public static void main(String[] args)
	{
//		declaration
		int arr[];
		String str[];
		
//		array construction
		arr=new int[3];
		str=new String[3];
		
//		length of the both array
		int size=arr.length;
		int size1=str.length;
		
		arr[0]=34;
		arr[1]=22;
		
		str[0]="java";
		str[1]="oracle";
		
		System.out.println("\nRetrive the first array element");
		
		for (int i = 0; i < size; i++)
		{
			System.out.println(arr[i]+"\t");
		}
		System.out.println("\nRetrive the second array element");
		for (int i = 0; i < size1; i++)
		{
			System.out.println(str[i]+"\t");
		} 
	}

}
