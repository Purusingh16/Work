package navigableSet;

import java.util.TreeSet;

public class NavigableSet_Demo {

	/**
	 * sortedSet
	 * =========
	 * first()
	 * last()
	 * headset()
	 * tailset()
	 * subset()
	 * ==========
	 * NavigableSet
	 * floor(e)
	 * ==>it returns highest element which is<=e
	 * lower(e)
	 * ==>it returns highest element which is<e
	 * ceiling(e)
	 * ==>it returns lowest element which is>=e
	 * higher(e)
	 * ==>it returns lowest element which is>e
	 * pollFirst()
	 * ==>remove and return first element
	 * pollLast()
	 * ==>remove and return last element
	 * descendingSet()
	 * it returns Navigable in reverse order
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeSet<Integer> t=new TreeSet<>();
		t.add(1000);
		t.add(2000);
		t.add(3000);
		t.add(4000);
		t.add(5000);
		System.out.println(t);//[1000,2000,3000,4000,5000]
		System.out.println(t.ceiling(2000));//2000
		System.out.println(t.higher(2000));//3000
		System.out.println(t.floor(3000));//3000
		System.out.println(t.lower(3000));//2000
		System.out.println(t.pollFirst());//1000
		System.out.println(t.pollLast());//5000
		System.out.println(t.descendingSet());//[4000, 3000, 2000]
		System.out.println(t);//[2000, 3000, 4000]
		
	}

}
