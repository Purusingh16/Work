package comparable_sorting;

import java.util.TreeSet;

public class Comparator_Comparable_demo 
{
	public static void main(String[] args)
	{
		Employee e1=new Employee("nag", 100);
		Employee e2=new Employee("balaiah", 200);
		Employee e3=new Employee("chiru", 50);
		Employee e4=new Employee("venki", 150);
		Employee e5=new Employee("nag", 100);
		
		TreeSet t=new TreeSet(new MyComparator());
		t.add(e1);
		t.add(e2);
		t.add(e3);
		t.add(e4);
		t.add(e5);
		System.out.println(t);
		
	}

}
