package autoboxing_unboxing;

public class Convert 
{
	public static void main(String[] args)
	{
		String s="35";
		byte b=Byte.parseByte(s);
		b++;
		System.out.println(b);//36
		
		int i=Integer.parseInt(s);
		i+=10;
		System.out.println(i);//45
		
		double d=Double.parseDouble(s);
		d+=5;
		System.out.println(d);//40.0
		
		String ss=Byte.toString(b);
		ss+=1;
		System.out.println(ss);//361
		
		String ss1=Integer.toString(i);
		ss1+=1;
		System.out.println(ss1);//451
		
		String ss2=Double.toString(d);
		ss2+=1;
		System.out.println(ss2);//40.01
	}

}
