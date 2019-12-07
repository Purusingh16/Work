package navigableMap;

import java.util.TreeMap;

public class NavigableMap_Demo {

	/**
	 * NavigableMAp
	 * floorKey(e)
	 * ==>it returns highest element which is<=e
	 * lowerKey(e)
	 * ==>it returns highest element which is<e
	 * ceilingKey(e)
	 * ==>it returns lowest element which is>=e
	 * higherKey(e)
	 * ==>it returns lowest element which is>e
	 * pollFirstEntry()
	 * ==>remove and return first element
	 * pollLastEntry()
	 * ==>remove and return last element
	 * descendingMap()
	 * it returns Navigable in reverse order
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeMap<String, String> t=new TreeMap<>();
		t.put("b", "banana");
		t.put("c", "cat");
		t.put("a", "apple");
		t.put("d", "dog");
		t.put("g", "gun");
		System.out.println(t);//{a=apple, b=banana, c=cat, d=dog, g=gun}
		System.out.println(t.ceilingKey("c"));//c
		System.out.println(t.higherKey("e"));//g
		System.out.println(t.floorKey("e"));//d
		System.out.println(t.lowerKey("e"));//d
		System.out.println(t.pollFirstEntry());//a=apple
		System.out.println(t.pollLastEntry());//g=gun
		System.out.println(t.descendingMap());//{d=dog, c=cat, b=banana}
		System.out.println(t);//{b=banana, c=cat, d=dog}
	}

}
