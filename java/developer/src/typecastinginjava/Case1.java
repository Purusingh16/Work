package typecastinginjava;

public class Case1
{
	public static void main(String[] args)
	{
		int i=1000;
//		final int i=10;
//		byte b=i;
//		System.out.println(b);
		System.out.println(i);
		
	}
	public static void main2(String[] args) 
	{
		int i=132;
		byte b=(byte) i;
		System.out.println(b);
	}
	public static void main1(String[] args) 
	{
		byte b=10;
		int i=b;
		long l=i;
		float f=l;
		System.out.println(b+" \t"+i+"\t"+l+"\t"+f);
		
	}

}
