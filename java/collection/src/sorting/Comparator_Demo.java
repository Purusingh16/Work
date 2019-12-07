package sorting;

import java.util.Comparator;
import java.util.TreeSet;

public class Comparator_Demo {

	/**
	 * util package
	 * meant for customize sorting order
	 * method
	 * ======
	 * 1.public int compare(Object obj1,Object obj2)
	 * -->returns -ve if obj1 has to come before obj2
	 * -->returns +ve if obj1 has to come after obj2
	 * -->returns 0 if obj1 and obj2 are equal.
	 * 2.public boolean equals(Object obj)
	 * @param args
	 */
	public static void main(String[] args) 
	{
		TreeSet t=new TreeSet(new My_Comparator());
		t.add(10);
		t.add(0);
		t.add(15);
		t.add(5);
		t.add(20);
		t.add(20);
		System.out.println(t);
		
		
	}

}


