package autoboxing_unboxing;

import java.util.Scanner;

public class Arm_Num
{
	public static void main(String[] args) 

	{
//		int num=Integer.parseInt(args[0]);
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the armstrong number");
		int num=scanner.nextInt();
		
		int i,j,sum=0;
		i=num;
		while(i>0)
		{
			j=i%10;
			sum+=(j*j*j);//sum=s um+(j*j*j);
			i/=10;
		}
		if(sum==num)
		{
			System.out.println("This is an armstrong number:"+num);
		}
		else
		{
			System.out.println("This is not armstrong number:"+num);
		}
	}

}
