package stringManipulation;

import java.util.HashMap;
import java.util.Iterator;

public class DuplicateString
{
	static void findDuplicateWord(String str)
	{
		HashMap<String , Integer> hashMap=new HashMap<>();
		String[] splitStr = str.split(" ");
//		System.out.println(splitStr);
		
		for (String tempString : splitStr) 
		{
//			System.out.println(tempString);
			if (hashMap.get(tempString)!=null)
			{
				hashMap.put(tempString, hashMap.get(tempString)+1);
			}
			else
			{
				hashMap.put(tempString, 1);
			}
			
		}
//		System.out.println(hashMap);
		Iterator<String> tempString = hashMap.keySet().iterator();
		while (tempString.hasNext()) 
		{
			String next = tempString.next();
			if (hashMap.get(next)>1) 
			{
//				System.out.println("How Word "+ next +" appred " + hashMap.get(next)+ " no of items");
				System.out.println(" "+ next + " - " + hashMap.get(next));

			}
		}
	}

	static void findDuplicateChar(String str) 
	{
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for(int i=0 ; i < str.length() ; i++)
		{
			char charAt = str.charAt(i);
			if (hashMap.get(charAt) !=null )
			{
				hashMap.put(charAt, hashMap.get(charAt)+1);
			}
			else 
			{
				hashMap.put(charAt, 1);
			}
		}
		Iterator<Character> iterator = hashMap.keySet().iterator();
		while(iterator.hasNext())
		{
			Character next = iterator.next();
			if (hashMap.get(next)>1) 
			{
				System.out.println(" "+next+" - "+hashMap.get(next));
			}
		}
		System.out.println(hashMap);
	}
	

	public static void main(String[] args) 
	{
		findDuplicateWord("I am am Learning Java Java");
		findDuplicateChar("JavaJ2EE");
		
	}

}
