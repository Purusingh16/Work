package javaApp;

public class Test2 
{
	int i;
	
	public Test2(int i) 
	{
		this.i=i;
	}
	public String toString()
	{
		return i+" ";
	}
	public int hashCode()
	{
		return i;
	}
	public static void main(String[] args)
	{
		Test2 t=new Test2(10);
		Test2 t2=new Test2(100);
		System.out.println(t);
		System.out.println(t2);
	}

}
