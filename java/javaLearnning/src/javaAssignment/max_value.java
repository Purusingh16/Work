package javaAssignment;

public class max_value {

	public static void main(String[] args) 
	{
		int[] number = { 1, 2, 3, 4, 5, 6, };
		int max_value = Integer.MIN_VALUE;
		for (int i = 0; i < number.length; i++) 
		{
			if (max_value < number[i])
			{
				max_value = number[i];
			}
		}
		System.out.println("maximum number is :" + max_value);
	}

}
