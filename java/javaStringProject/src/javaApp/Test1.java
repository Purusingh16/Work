package javaApp;

import java.util.ArrayList;

public class Test1 
{
	public String toString()
	{
		return "Test1";
	}
	public static void main(String[] args)
	{
		String string=new String("depak");
		System.out.println(string);
		
		Integer integer=new Integer(10);
		System.out.println(integer);
		
		ArrayList eList=new ArrayList();
		eList.add("A");
		eList.add("B");
		System.out.println(eList);
		Test1 t=new Test1();
		System.out.println(t);

	}

}
