package set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Linked_HashSet_Demo {

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
	 * @param args
	 */
	public static void main(String[] args)
	{
		LinkedHashSet h=new LinkedHashSet();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the string:");
		String str=s.next();
		for (int i = 0; i < str.length(); i++)
		{
			
		}
		
		h.add("B");
		h.add("C");
		h.add("D");
		h.add("Z");
		h.add(null);
		h.add(10);
		System.out.println("hashset:"+h.add("Z"));//false
		System.out.println(h);//[null, B, C, D, Z, 10]
		


	}

}
