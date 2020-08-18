package com.collection.pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class DemoList {

	public static void printList(Employee[] e) {
		ArrayList empList=new ArrayList();
		for(int i=0;i<e.length;i++)
			empList.add(e[i]);
		
		Collections.sort(empList,new IdComparator());
		
		
		Iterator empiterator=empList.iterator();
		while(empiterator.hasNext())
			System.out.println(empiterator.next());
		
	}

}
