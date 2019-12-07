package javaApp;

public class Test3 
{
	public static void main(String[] args)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("durga").append("softwre").append("solution").insert(3,"purushottam").delete(3, 8).append("sr nagar");
		System.out.println(sb);
		
	}
	public static void main5(String[] args)
	{
		StringBuffer sb=new StringBuffer("purottam");
		sb.insert(3,"ush");
		System.out.println(sb);
	}
	public static void main4(String[] args)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("PI value is:");
		sb.append(3.14);
		sb.append("It is exactly:");
		sb.append(true);
		System.out.println(sb);
		
	}
	public static void main3(String[] args)
	{
		StringBuffer sb=new StringBuffer();
		sb.append("abcdehjkldunvbny");
		sb.append("c");
		System.out.println(sb.capacity());
	}
	public static void main2(String[] args) 
	{
		final StringBuffer stringBuffer=new StringBuffer("durga");
				stringBuffer.append("software");
				System.out.println(stringBuffer);
//				stringBuffer=new StringBuffer("solution");
	}
	public static void main1(String[] args) 
	{
		String s1=new String("durga");
		String s2=s1.toUpperCase();
		String s3=s1.toLowerCase();
		System.out.println(s1==s2);
		System.out.println(s1==s3);
	}

}
