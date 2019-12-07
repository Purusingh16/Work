package list;

import java.util.ArrayList;

public class ArrayListDemo {

	/**
	 * if we want to represent group of individual object as a single entity. 
	 * 9 key interfaces of collection framework.
	 * =========================================
	 * 1.collection 2.List 3.set 4.sortedSet 5.Navigable Set
	 * 6.Queue 7.Map 8.sortedMap 9.NavigableMap
	 * ==========================================================
	 * public boolean add(Object element) is used to insert an element in this collection.
	 * public boolean addAll(Collection c) is used to insert the epecified collection elements in the invoking collection.
	 * public boolean remove(Object element) is used to delete an element from this collection.
	 * public boolean removeAll(Collection c) is used to delete all the elements of specified collection from the envoking collection.
	 * public bollean retainAll(collection c) is used to delete all the element of invoking collection except the specified collection.
	 * public int size() return the total number of elements in the collection.
	 * public void clear() remove all the total number of element from the collection.
	 * public boolean contains(Object element)is used to search an element.
	 * public boolean containsAll(Collection c)is used to search the specified collection in this collection.
	 * public Iterator iterator() returns an iterator
	 * public Object[] toArray() converts collection into array.
	 * public boolean isEmpty() checks if collection is empty.
	 * public boolean equals(Object element) match two collection.
	 * public int hascode() returns the hascode number for collection.
	 * 
	 * void add(int index,Object o)
	 * boolean addAll(int index,Collection c)
	 * Object get(int index)
	 * Object remove(int index)
	 * 
	 * Object set(int index,Object new) to replace the element present at specified index with provided Object and returns old object.
	 * int indexOf(Object o) returns index of first occurrence of "o".
	 * int lastIndexOf(Object o)
	 * ListIterator listIterator();  
	 * 
	 * five point of ArrayList:
	 * 1.Resizable Array or Growable Array
	 * 2.duplicate are allowed
	 * 3.Insertion order preserved
	 * 4.Hetrogenous object
	 * 5.null insertion
	 * @param <E>

	 */
	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		list.add("A");
		list.add(10);
		list.add("A");
		list.add(null);
		System.out.println(list);//[A,10,A,null]
		list.remove(2);
		System.out.println(list);//[A,10,null]
		list.add(2, "A");
		System.out.println(list);//[A, 10, A, null]
		list.add("N");
		System.out.println(list);//[A, 10, A, null, N]
//		list.get(1);
		System.out.println(list);
		
	}

}
