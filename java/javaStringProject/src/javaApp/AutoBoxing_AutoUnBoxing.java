package javaApp;

public class AutoBoxing_AutoUnBoxing 
{
	
//	static Integer I=0;
	static Integer I;
	public static void main(String[] args)
	{
		int m=I;
		System.out.println(m);
	}
//	static Integer I=10;//A.B
	
	public static void main1(String[] args) 
	{
		int i=I;//AUB
		m1(i);
		
	}
	public static void m1(Integer k)//AB
	{
		int m=k;//AUB
		System.out.println(m);
	}
}
