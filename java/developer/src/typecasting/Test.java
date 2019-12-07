package typecasting;

public class Test 
{
	public static void main3(String[] args)
	{
		final int i=128;
		byte b=(byte)i;
		System.out.println(b);
	}
	public static void main(String[] args)
	{
		final int i=129;
		byte b=(byte)i;
		System.out.println(b);
	}
	public static void main1(String[] args)
	{
		int i=134;
		
		byte b=(byte)i;
		System.out.println(b);
		
	}

	public static void main0(String[] args) 
	{
		double d=88.9;
		float f=(float)d;
		long l=(long)f;
		int i=(int)l;
		byte b=(byte)i;
		
		System.out.println(d+"\t"+f+"\t"+l+"\t"+i+"\t"+b);
		
		byte bb=100;
		int ii=bb;
		long ll=ii;
		float ff=ll;
		double dd=ff;
		
		System.out.println(bb+"\t"+ii+"\t"+ll+"\t"+ff+"\t"+dd);
	}

}
