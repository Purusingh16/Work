package arrayClass;

import java.util.Scanner;

public class Test 
{
	public static int getMaxValue(int[] ages)
	{  
	    int maxValue = ages[0];  
	    for(int i=1;i<ages.length;i++)
	    {  
	        if(ages[i] > maxValue)
	        {  
	            maxValue = ages[i];  
	        }  
	    }  
	    return maxValue;  
	}  
	public static int getMinValue(int[] ages)
	{
		int minValue=ages[0];
		for(int i=1;i<ages.length;i++)
		{
			if(ages[i] < minValue)
			{
				minValue=ages[i];
			}
		}
		return minValue;
	}
	
	public static void main(String[] args) 
	{
//		int[] ages={10,20,30,40,50};
		int[] ages = new int[5];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < ages.length; i++) 
		{
			System.out.print("Enter Age:");
			ages[i] = sc.nextInt();
		}
			for (int i = 0; i < ages.length; i++)
			{
				System.out.print(ages[i]+" ");
				
			}
			System.out.println();
			   System.out.println("Minimum Value = " + getMinValue(ages));  
			   System.out.println("Maximum Value = " + getMaxValue(ages)); 
			
//			System.out.println();
			int tot=0;
			for (int j = 0; j < ages.length; j++) 
			{
				
				tot=tot+ages[j];
				
			}
			System.out.println("");
			System.out.println("tot ages obtained:"+tot);
			System.out.println("average:"+tot/ages.length);
	}
	

}
