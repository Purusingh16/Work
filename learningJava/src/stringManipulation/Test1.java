package stringManipulation;

public class Test1 
{
	public static void main(String[] args)
	{
		String str=new String("Durga Software Solutions");
		System.out.println(str.length());
	}
	public static void main2(String[] args)
	{
		char[] ch={'A','B','C','D','E','F'};
		String str=new String(ch,1,3);
//		String str=new String(ch);
		System.out.println(str);
	}
	public static void main1(String[] args)
	{
		byte[] b={65, 66, 67, 68, 69, 70};
		String str=new String(b,1,3);
		System.out.println(str);
	}
	public static void main0(String[] args)
	{
		byte[] b={65, 66, 67, 68, 69, 70};
		String str=new String(b);
		System.out.println(str);
	}

}
