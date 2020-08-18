package com.collection.pack;
import java.util.*;
public class DemoIterator {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add("Hello");
		list.add("World");
		list.add("Capgemini");
		list.add(101);
		list.add('a');
		list.add("Hello");
		System.out.println(list);
		Iterator i=list.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		list.forEach(item->System.out.print(item));

	}

}
