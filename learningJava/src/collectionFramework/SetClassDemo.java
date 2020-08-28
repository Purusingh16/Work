package collectionFramework;

import java.util.HashSet;
import java.util.Iterator;

public class SetClassDemo {
//	hashset, linkedhashset, treeset---implements set interface
//	cannot accept duplicate element
//	data stored in random oerder, do not stored in sequential order.

	public static void main(String[] args) {
		
		HashSet<String> hashSet=new HashSet<>();
//		System.out.println(hashSet.isEmpty());
		hashSet.add("USA");
		hashSet.add("UK");
		hashSet.add("India");
		hashSet.add("Australlia");
		hashSet.add("Argentina");
		hashSet.add("Singapore");
//		System.out.println(hashSet);
//		hashSet.remove("UK");
		System.out.println(hashSet);
//		System.out.println(hashSet.isEmpty());
//		System.out.println(hashSet.size());
		
		Iterator<String> iterator=hashSet.iterator();
		while (iterator.hasNext()) 
		{
			String string = (String) iterator.next();
//			System.out.println(iterator.next());
			System.out.println(string);
			
		}
		
		
	}

}
