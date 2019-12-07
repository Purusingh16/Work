package hashMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap_Demo 
{

	public static void main(String[] args) 
	{
		HashMap<String, Integer> m=new HashMap<String, Integer>();
		m.put("chiranjeevi", 700);
		m.put("balaiah", 800);
		m.put("venkatesh", 200);
		m.put("nagarjuna", 500);
		
		System.out.println(m);
		System.out.println(m.put("chiranjeevi", 1000));
		Set<String> s=m.keySet();
		System.out.println(s);
		
		Collection<Integer> c=m.values();
		System.out.println(c);
		
		Set<?> s1=m.entrySet();
		System.out.println(s1);
		
		Iterator<?> itr=s1.iterator();
		while (itr.hasNext())
		{
			Map.Entry<?, Integer> m1=(Map.Entry) itr.next();
			System.out.println(m1.getKey()+"....."+m1.getValue());
			if (m1.getKey().equals("nagarjuna"))
			{
				m1.setValue(10000);
			}
		}
		System.out.println(m);

	}

}
