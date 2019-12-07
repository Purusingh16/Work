package sortedMap;

import java.util.TreeMap;

public class TreeMap_Demo {

	/**
	 * TreeMap t=new TreeMap();
	 * ==>for default natural sorting order
	 * TreeMap t=new TreeMap(Comparator c);
	 * ==>for customized sorting order
	 * TreeMap t=new TreeMap(SortedMap m);
	 * TreeMap t=new TreeMap(Map m);
	 * @param args
	 */
	public static void main(String[] args)
	{
		TreeMap m=new TreeMap(new MyComparator());
		m.put("XXX", 10);
		m.put("AAA", 20);
		m.put("ZZZ", 30);
		m.put("LLL", 40);
		
		System.out.println(m);//{ZZZ=30, XXX=10, LLL=40, AAA=20}
		
	}
	public static void main0(String[] args)
	{
		TreeMap t=new TreeMap();
		t.put(100, "ZZZ");
		t.put(103, "YYY");
		t.put(101, "XXX");
		t.put(104, 106);
		
//		t.put("FFF", "XXX");//CCE
//		t.put(null, "XXX");//NPE
		
		System.out.println(t);//{100=ZZZ, 101=XXX, 103=YYY, 104=106}

	}

}
