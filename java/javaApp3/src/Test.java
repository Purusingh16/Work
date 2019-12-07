
public class Test 
{
	
	public static void main10(String[] args)
	{
		int count=10;
		int n1 = 0,n2=1,n3=0;
		System.out.print(n1+" "+n2);
		Fibonacii_num(10);
	}
	public static int Fibonacii_num(int count)
	
	{
		int n1=0,n2=1,n3=0;
		for(int i=2;i<count;i++)
		{
			n3=n1+n2;
			n1=n2;
			n2=n3;
			System.out.print(" "+n3);
		}
		return n3;
		
	}
	public static void main9(String[] args)
	{
		palindrome_num(454);
	}
	public static int palindrome_num(int num)
	{
		int rem,sum=0,temp;
		
		temp=num;
		while(num>0)
		{
			rem=num%10;
			sum=(sum*10)+rem;
			num=num/10;
		}
		if(temp==sum)
			System.out.println(num+":is palindrome number");
		else
			System.out.println((num+":is not a palindrome number"));
	return num;	
	}
	public static void main8(String[] args)
	{
		int num=0;
		System.out.println("gerater number is:"+max_value(num));
	}
	public static int max_value(int num)
	{
		int[] num1={2,4,8,5};
		int max_value=Integer.MIN_VALUE;
		for(int i=0;i<num1.length;i++)
		{
			if(max_value<num1[i])
			{
				max_value=num1[i];
			}
		}
		return max_value;
	}
	public static void main7(String[] args)
	{
		
		int num=0;
		System.out.println("smallest number is:"+min_value(num));
	}
	public static int min_value(int num)
	{
		int[] num1={3,4,7,2};
		int min_value=Integer.MAX_VALUE;
		for(int i=0;i<num1.length;i++)
		{
		if(min_value>num1[i])
		{
			min_value=num1[i];
		}
		}
		return min_value;
	}
	public static void main90(String[] args)
	{
		System.out.println("reverse number is:"+reverse_Num(123));
	}
	public static int reverse_Num(int num)
	{
		int reverse=0;
		while(num!=0)
		{
		reverse=reverse*10;
		reverse=reverse+num%10;
		num=num/10;
		}
		return reverse;
		
	}
	public static void main5(String[] args)
	{
		System.out.println("sum_of_given_num is:"+add_digit_num(555));
	}
	public static int add_digit_num(int num)
	
	{
		int sum=0,r;
		while(num>0)
		{
		r=num%10;
		num=num/10;
		sum=sum+r;
		}
		return sum;
	}
	public static void main4(String[] args)
	{
		even_odd(6);
	}
	public static int even_odd(int num)
	{
		if(num%2==0)
			System.out.println(num+":is even number");
		else
			System.out.println(num+":is odd number");
		return num;
	}
	public static void main3(String[] args) 
	{
		System.out.println("Factorial="+factorial(3));
	}
	
	public static int factorial(int num)
	{
		int i=1,fact=1;
		
		for(i=1;i<=num;i++)
		{
			fact=fact*i;
		}
		return fact;
	}
	
	public static void main2(String[] args) 
	{
		/*for(int i=5;i>=1;i--)
			System.out.println("HelloWorld");*/
		
		int i=0;
		while(i<50)
		{
			System.out.println("HelloWorld");
			i++;
		}
	}
	public static void main1(String[] args) 
	{
		int avg = calAverage(10,20);
		System.out.println("Average:"+avg);
	}
	public static int calAverage(int a,int b)
	{
		return (a+b)/2;
	}
}
