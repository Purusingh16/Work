package stringConcatination;

public class Equals 
{
	public static void main(String[] args)
	{
		String s1=new String("java");
		String s2="java";
		String s3="JAVA";
		String s4="java";
		
		String s5=new String("java");
		
		if(s1==s2)
		{
			System.out.println("Equals");
		}
		else
		{
			System.out.println("Not Equals");
		}
		
		if(s1.equals(s5))
		{
			System.out.println("Equals");
		}
		else
		{
			System.out.println("Not Equals");
		}
	}

}
