package list;

import java.util.LinkedList;

public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		LinkedList ll=new LinkedList<>();
		ll.add("durga");
		ll.add(30);
		ll.add(null);
		ll.add("durga");
		System.out.println(ll);//[durga, 30, null, durga]
		ll.set(0, "software");
		System.out.println(ll);//[software, 30, null, durga]
		ll.add(0, "vinky");
		System.out.println(ll);//[vinky, software, 30, null, durga]
		ll.removeLast();
		System.out.println(ll);//[vinky, software, 30, null]
		ll.addFirst("dipu");
		System.out.println(ll);//[dipu, vinky, software, 30, null]
		
	}

}
