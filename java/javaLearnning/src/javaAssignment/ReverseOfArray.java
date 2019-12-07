package javaAssignment;

public class ReverseOfArray {

	
	public static void main(String[] args) {
		int[] array={6,4,5,2};
		int c=0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<array.length;j++)
			{
				if(array[i]<array[j])
				{
					c=array[i];
					array[i]=array[j];
					array[j]=c;
				}
			}

		}
		for(int i=0;i<array.length;i++)
		{
			System.out.println(array[i]);
		}
		
	}

}
