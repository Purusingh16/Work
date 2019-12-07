package set;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSet_Demo {

	/**
	 * 100
	 * 101
	 * 104
	 * 106
	 * 110
	 * 115
	 * 120
	 * 
	 * first()=100
	 * last()=120
	 * headset(106)=[100,101,104]
	 * tailset(106)=[106,110,115,120]
	 * subset(101,115)=[101,104,106,110]
	 * comparator()=null
	 * @param <E>
	 * @param args
	 */
	public static  void main1(String[] args)
	{
		NavigableSet av=new TreeSet();
		av.add("A");
		av.add("a");
		av.add("B");
		av.add("Z");
		av.add("L");
//		t.add(new Integer(10));
//		t.add(null);
		av.add("k");
		System.out.println(av);//[A, B, L, a, z]
		
	}

	public static void main(String[] args)
	{
		TreeSet t=new TreeSet();
		t.add("A");
		t.add("a");
		t.add("B");
		t.add("Z");
		t.add("L");
//		t.add(new Integer(10));
//		t.add(null);
		t.add("k");
		System.out.println(t);//[A, B, L, a, z]
		
	}
}
