package javaAssignment;

public class evenOdd {


	public static void main(String[] args) {
		int[] number={1,2,3,4,5,6};
		
		for(int i=0;i<number.length;i++)
		{
			if (number[i]%2==0)
				System.out.println(number[i]+"is even number.");
			else
				System.out.println(number[i]+"is odd number.");
		}
		

	}

}
