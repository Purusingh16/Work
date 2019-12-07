package javaAssignment;

public class min_value {

	public static void main(String[] args) {

		int[] number = { 1, 2, 3, 4, 5 };
		int min_value = Integer.MAX_VALUE;
		for (int i = 0; i < number.length; i++)
		{
			if (min_value> number[i])
			{
				min_value = number[i];
			}
		}
				System.out.println("smallest number is :" + min_value);
			}

		}

	

