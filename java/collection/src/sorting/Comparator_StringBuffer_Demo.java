package sorting;

import java.util.TreeSet;

public class Comparator_StringBuffer_Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeSet t=new TreeSet(new My_Comparator1());
		t.add(new StringBuffer("A"));
		t.add(new StringBuffer("Z"));
		t.add(new StringBuffer("k"));
		t.add(new StringBuffer("L"));
		System.out.println(t);
	}

}
