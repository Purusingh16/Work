package projectApp;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo 
{
	public static void main(String[] args) 
	{
//		Map<String, String> map=new HashMap<String, String>();
		Map<Integer, Integer> map2=new HashMap<Integer,Integer>();
		
		map2.put(4, 1);
		map2.put(3, 2);
		
		for (Map.Entry<Integer, Integer> entry:map2.entrySet())
		{
			System.out.println(entry.getKey()+"frequency");
			System.out.println(entry.getValue());
			
		}
		

	}

}
