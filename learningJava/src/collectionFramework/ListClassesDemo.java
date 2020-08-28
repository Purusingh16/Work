package collectionFramework;

import java.util.ArrayList;

public class ListClassesDemo {
//	can accept duplicate values
//	arraylist, linkedlist, vector- Implementing list interface
	
	public static void main(String[] args)
	{
		ArrayList<String> arrayList=new ArrayList<String>();
		arrayList.add("rahul");
		arrayList.add("Puru");
		arrayList.add("student");
		System.out.println(arrayList);
		arrayList.add(0, "Java");
		System.out.println(arrayList);
//		stringlist.remove(0);
//		System.out.println(arrayList);
//		stringlist.remove("rahul");
		System.out.println(arrayList);
		System.out.println(arrayList.get(0));
		System.out.println(arrayList.contains("ram"));
		System.out.println(arrayList.indexOf("Puru"));
		System.out.println(arrayList.isEmpty());
		System.out.println(arrayList.size());
		
		
	}

}
