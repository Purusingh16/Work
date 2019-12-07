package operator;

public class Text1 
{
	public static void main(String[] args)
	{
		int x=1;
		for (int i = 0; i <= 3; i++) 
		{
			switch(i)
			{
			case 1:
				x++;
				System.out.println(x);
				break;
			case 2:
				x++;
				System.out.println(x);
				break;
			case 3:
				x++;
				System.out.println(x);
				break;
			default:
				x++;
				System.out.println("default value:"+x);
			}
			
		}
//		System.out.println("X value is:"+x);
	}
	public static void main12(String[] args)
	{
		int i=100;
		switch(i)
		{
		case'a':
			System.out.println("A");
		case'b'+10:
			System.out.println("B");
		case'c'+1:
			System.out.println("c");
		}
	}
	public static void main11(String[] args)
	{
		byte l=1;
		switch(l)
		{
		default:
			System.out.println("A");
		
		case 1:
			System.out.println("B");
			break;
		case 10:
			System.out.println("C");
			break;
		}
	}
	public static void main10(String[] args)
	{
		Boolean bb=new Boolean("java");
		if(bb)
		{
			System.out.println("A");
		}
		else if(bb)
		{
			System.out.println("B");
		}
		else if(bb)
		{
			System.out.println("C");
		}
		else if(bb=true)
		{
			System.out.println("D");
		}
		else
		{
			System.out.println("E");
		}
	}
	
	public static void main9(String[] args)
	{
		boolean i;
		if(i=false)
		{
			System.out.println("c application");
		}
		else
		{
			System.out.println("java aplication");
		}
		
	}
	public static void main8(String[] args)
	{
		int i=6;
		System.out.println((i==5)?5:1.0);
	}
	public static void main7(String[] args)
	{
		int i=11;
		int x=(int) ((i==10)?10:1.0);
		System.out.println(x);
	}
	public static void main6(String[] args)
	{
		Integer i1=new Integer(100);
		Integer i2=new Integer(100);
//		if(i1==i2)
		if(i1.equals(i2))
		{
			System.out.println("Equals");
		}
		else
		{
			System.out.println("Not Equals");
		}
		
	}
	public static void main5(String[] args)
	{
		int i=5;
		//int j=i++ + i-- - i++;
				
				// you have to read about operator precedence in java
				// multiplication and division has more priority than addition and subtraction
				//
				int j=i++ + i-- - i++ * ++i / i++;
				
				//we can right above statement as
				/*
				 *  j= (i++ + i--) - ((i++ * ++i)/i++)
				 *  so 
				 *  j= (5+6) - ((5*7)/7) and here last value of i is 7 thus i=7++=8
				 *  j= (11) - (35/7)
				 *  j= 11 - (5)
				 *  j= 11 - 5
				 *  j= 6 and i=8
				 */
				System.out.println(i+"\t"+j);
		
	}
	public static void main4(String[] args)
	{
		int i=5;
		int j=i++ + i-- - i++ * ++i / i++;
//		int j=i++ + i-- - i++ * ++i / i++;
		System.out.println(i+"\t"+j);
		
	}
	public static void main3(String[] args)
	{
		
		int i=3;
//		System.out.println(i++);
//		System.out.println(++i);
//		int j=i++ + i++ + ++i + i-- + i++;
		int j=i++ + i++ + ++i + i-- + i++;
		System.out.println(i+"\t"+j);
		
	}
	public static void main2(String[] args)
	{
		int i=5;
		System.out.println(i++);
		System.out.println(i++);
		System.out.println(i);
	}
	public static void main1(String[] args)
	{
		int i=5;
		int j=i++;
		System.out.println(i+"\t"+j);
	}
	public static void main0(String[] args)
	{
		int i=5;
		i=i++;
		System.out.println(i+"\t"+i);
	}

}
