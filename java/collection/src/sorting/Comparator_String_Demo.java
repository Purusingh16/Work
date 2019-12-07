package sorting;

import java.util.TreeSet;

public class Comparator_String_Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		TreeSet t=new TreeSet(new Comparator_Demo1());
		t.add("Roja");
		t.add("ShpbhaRani");
		t.add("RajaKumari");
		t.add("GangaBhavani");
		t.add("Ramulamma");
		
		System.out.println(t);
		
	}

}
