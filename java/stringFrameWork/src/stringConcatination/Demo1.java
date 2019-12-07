package stringConcatination;

public class Demo1 
{
	public static void main(String[] args)
	{
		String s1=new String("java");
		String s2="java";
		String s3="JAVA";
		
		if(s1==s2)
		{
			System.out.println("Equals");
		}else
		{
			System.out.println("Not Equals");
		}
		if (s1.equals(s2))
		{
			System.out.println("Equals");
		}else
		{
			System.out.println("Not Equals");
		}
		if (s2.equals(s3))
		{
			System.out.println("Equals");
		}else
		{
			System.out.println("Not Equals");
		}
		if (s2.equalsIgnoreCase(s3))
		{
			System.out.println("Equals");
		}else
		{
			System.out.println("Not Equals");
		}
		String ss=s2.replace('a', 'r');
		System.out.println(ss+"\t"+s2);
		
		String a="This is ";
		String b=a.concat(s2);
		System.out.println(b);
		System.out.println(a);
	}

}
