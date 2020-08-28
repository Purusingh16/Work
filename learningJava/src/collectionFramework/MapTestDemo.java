package collectionFramework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTestDemo {

	public static void main(String[] args) 
	{
//		HashMap, LinkedHashMap, Treemap----Implements Map
//		Map Interface---extends---SortedMap
		
		HashMap<Integer, String> hashMap=new HashMap<>();
		hashMap.put(0, "UK");
		hashMap.put(1, "India");
		hashMap.put(10, "Australlia");
		hashMap.put(3, "China");
		System.out.println(hashMap);
//		System.out.println(hashMap.get(10));
//		hashMap.remove(10);
//		System.out.println(hashMap.get(10));
		Set setIterator=hashMap.entrySet();
		Iterator iterator=setIterator.iterator();
		while (iterator.hasNext()) 
		{
//			String string = (String) iterator.next();
			Map.Entry<Integer, String> mapEntry=(Map.Entry<Integer, String>)iterator.next();
//			System.out.println(iterator.next());
//			System.out.println(mapEntry);
			System.out.println(mapEntry.getKey()+" "+mapEntry.getValue());
		}
	}

}
