package javaAssignment;

public class SortingArray {

public static void main(String[] args)
{
	int b=0;
	int arr[] = { 3, 4, 2, 5, 1 };
	{
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++) 
			{
				if (arr[i] > arr[j])
				{	
					b= arr[i];
				arr[i] = arr[j];
				arr[j] = b;
				}
			}
			System.out.println("sorting:"+arr[i]);
			
		}
	}

}
}
