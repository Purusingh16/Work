package operators;

public class ArithmeticDemo 
{
	public static void main(String[] args)
	{
		int x=1;
		int j=--x + x-- + ++x + x++;
		System.out.println(j+".."+x);
	}
	public static void main3(String[] args)
	{
//		 	PrePostDemo
		 	int i = 3;
	        i++;
	        // prints 4
	        System.out.println(i);
	        ++i;			   
	        // prints 5
	        System.out.println(i);
	        // prints 6
	        System.out.println(++i);
	        // prints 6
	        System.out.println(i++);
	        // prints 7
	        System.out.println(i);
	}
	public static void main2(String[] args)
	{
//		UnaryDemo
		int result = +1;
        // result is now 1
        System.out.println(result);

        result--;
        // result is now 0
        System.out.println(result);

        result++;
        // result is now 1
        System.out.println(result);

        result = -result;
        // result is now -1
        System.out.println(result);

        boolean success = false;
        // false
        System.out.println(success);
        // true
        System.out.println(!success);
	}
	public static void main1(String[] args)
	{
//			ConcatDemo
		 	String firstString = "This is";
	        String secondString = " a concatenated string.";
	        String thirdString = firstString+secondString;
	        System.out.println(thirdString);
		
	}

	public static void main0(String[] args)
	{
		int result = 1 + 2;
        // result is now 3
        System.out.println("1 + 2 = " + result);
        int original_result = result;
        
        result = result - 1;
        // result is now 2
        System.out.println(original_result + " - 1 = " + result);
        original_result = result;

        result = result * 2;
        // result is now 4
        System.out.println(original_result + " * 2 = " + result);
        original_result = result;

        result = result / 2;
        // result is now 2
        System.out.println(original_result + " / 2 = " + result);
        original_result = result;

        result = result + 8;
        // result is now 10
        System.out.println(original_result + " + 8 = " + result);
        original_result = result;

        result = result % 7;
        // result is now 3
        System.out.println(original_result + " % 7 = " + result);


	}

}
