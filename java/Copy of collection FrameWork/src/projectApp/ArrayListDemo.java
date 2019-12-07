package projectApp;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo 
{
	public static void main(String[] args)
	{
		ArrayList<Integer> intergers=new ArrayList<>();
		intergers.add(4);
		intergers.add(5);
		
		intergers.add(3);
		intergers.add(7);
		intergers.add(6);
		
		for (Integer integer : intergers) 
		{
			System.out.println(integer+" ");
		}
		Collections.sort(intergers);
		System.out.println("after sorting element are:");
		for (Integer sort : intergers) 
		{
			System.out.println(sort);
		}
		Collections.reverse(intergers);
		System.out.println("after reversing");
		for (Integer rev : intergers) 
		{
			System.out.println(rev);
		}
		Integer min= Collections.min(intergers);
		
		System.out.println("minium value:"+min);
		
		Integer max=Collections.max(intergers);
		System.out.println("maximum value:"+max);
	}

	
	public static void main1(String[] args)
	{
		ArrayList<Integer> intergers=new ArrayList<>();
		intergers.add(4);
		intergers.add(5);
		
		intergers.add(6);
		intergers.add(7);
		intergers.add(8);
		
		System.out.println("arraylist before removing any element");
		for (Integer int1: intergers) 
		{
			System.out.println(int1+" ");
		}
		System.out.println();
		intergers.remove(0);
		System.out.println("Arraylist after removing some element");
		
		for (Integer int2 : intergers) 
		{
			System.out.println(int2+" ");
		}
		System.out.println();
		intergers.add(2,40);
		System.out.println("Arraylist after insert some element at given index");
		for (Integer integer : intergers) 
		{
			System.out.println(integer+" ");
		}
		
				
 
	}

}
