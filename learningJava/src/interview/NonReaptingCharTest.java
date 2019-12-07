package interview;

import java.util.HashMap;

public class NonReaptingCharTest 
{

	public static void main(String[] args)
	{
		String str="test";
		HashMap<Character, Integer> nonrep=new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			Character c=str.charAt(i);
			
			if (nonrep.containsKey(c)) {
				nonrep.put(c, nonrep.get(c)+1);
				
			}else {
				nonrep.put(c, 1);
			}
		}
		for (int q = 0; q < str.length(); q++) {
			Character c=str.charAt(q);
			
			if (nonrep.get(c)==1) {
				System.out.println(c);
					
				
			}
			
		}
		
		

	}

}
