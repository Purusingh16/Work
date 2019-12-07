package hashMap;

import java.util.LinkedHashMap;

public class LinkedHashMap_Demo {

	/**
	 * in linkedhashmap insertion order is preserved but in case of hashmap insertion order is not perserved.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		LinkedHashMap m=new LinkedHashMap();
		m.put("chiranjeevi", 700);
		m.put("balaiah", 800);
		m.put("venkatesh", 200);
		m.put("nagarjuna", 500);
		
		System.out.println(m);//{chiranjeevi=700, balaiah=800, venkatesh=200, nagarjuna=500}
		
		
	}

}
