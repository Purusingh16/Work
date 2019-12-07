package collections;

import java.util.ArrayList;
import java.util.Collections;

import navigableSet.MyComparator_Demo;

public class Collections_Demo {

	/**
	 * public static void sort(List l)
	 * ==>to sort based on Deafault natural sorting order
	 * public static void sort(List l,comparator c)
	 * ==>to sort based on customized Sorting order	
	 * @param args
	 */
	public static void main(String[] args)
	{
		ArrayList l=new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("k");
		l.add("L");
		l.add(new Integer(10));//---CCE
		l.add(null);//---NPE
		System.out.println("Before Sorting:"+l);
		Collections.sort(l,new MyComparator_Demo());
		System.out.println("After Sorting:"+l);
		
	}
	public static void main0(String[] args) 
	{
		ArrayList l=new ArrayList();
		l.add("Z");
		l.add("A");
		l.add("k");
		l.add("N");
//		l.add(new Integer(10));//---CCE
//		l.add(null);//---NPE
		System.out.println("Before Sorting:"+l);
		Collections.sort(l);
		System.out.println("After Sorting:"+l);
	}

}
