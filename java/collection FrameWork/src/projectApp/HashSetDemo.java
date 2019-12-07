package projectApp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo
{
	public static void main (String[] args)
	{
		Set<Integer> set=new HashSet<Integer>();
		set.add(40);
		set.add(50);
		set.add(60);
		set.add(40);
		
		ArrayList<Integer> intergers=new ArrayList<>();
		intergers.add(4);
		intergers.add(5);
		intergers.add(5);
		Set<Integer> set2=new HashSet<Integer>();
		set2.addAll(intergers);
		
		for (Integer integer : set) 
		{
			System.out.println(integer+" ");
			
		}
		for (Integer element : set2) 
		{
			System.out.println(element+" ");
			
		}
	}

}
