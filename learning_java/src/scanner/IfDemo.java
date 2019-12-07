package scanner;

public class IfDemo
{
	public static void main(String[] args)
	{
		/*for (int i = 0; i < 10; i++) 
		{
			if(i%2!=0)
			{
				continue;
			}
			System.out.println(i);
		}*/
		int array[]={2,44,33,55};
		for (int i = 0; i < array.length; i++) 
		{
			if(array[i]==44)
			{
				System.out.println(" successfully found");
				break;
			}
			
		}
		
		
		
	}
	
	public static void main4(String[] args)
	{
		int array[]={5,4,1,2};
		
		int temp=0;
		
		for (int i = 0; i < array.length; i++) 
		{
			for (int j =i+1; j < array.length; j++) 
			{ 
				if(array[i]>array[j])
				{
					temp=array[i];
					array[i]=array[j];
					array[j]=temp;
				}
			}
		}
		for (int index = 0; index < array.length; index++) 
		{
			System.out.print(array[index]+" ");
			
		}
		
	}
	public static void main3(String[] args)
	{
		int array[]={5,4,1,2};
		int largest_num=array[0];
		
		for (int i = 0; i < array.length; i++) 
		{
			if(largest_num>array[i])
			{
				largest_num = array[i];
			}
		}
		System.out.println("largest number:"+largest_num);
		
	}
	
	public static void main2(String[] args)
	{
		 int array[]={5,4,1,2};
		 int smallest_num=array[0];
		 
		 for (int i = 0; i < array.length; i++) 
		 {
			 if(smallest_num>array[i])
			 {
				 smallest_num=array[i];
			 }
			
		}
		 System.out.println("Smallest number is:"+smallest_num);
		
	}

	public static void main1(String[] args)
	{
		int a=10;
		int b=20;
		int c=30;
		
		if(a>b && a>c)
		{
			System.out.println("a is largest number:"+a);	
		}
		else if(b>a && b>c)
		{
			System.out.println("b is largest number:"+b);
		}
		else
		{
			System.out.println("c is largest number:"+c);
		}

	}

}
