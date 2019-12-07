package javaAssignment;

public class Test {

	
	public static void main(String[] args)
	{
		int arr[]={56,58,62,55};
		int arr1[]={80,90,70,50,60};
		Sorting_of_Array(arr1);
		Reverse_of_Array(arr);
	}
	public static void Reverse_of_Array(int arr[])
	{
		int c=0;
		
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					c=arr[i];
					arr[i]=arr[j];
					arr[j]=c;
					
				}
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	public static void Sorting_of_Array(int arr[])
	{
		int b=0;
		
		{
			for(int i=0;i<arr.length;i++)
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if(arr[i]>arr[j])
					{
					b=arr[i];
					arr[i]=arr[j];
					arr[j]=b;
					}
				}
				System.out.println("sorting:"+arr[i]);
			}
		}
		
	}

}
