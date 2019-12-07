package cursor;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * forward movement
 * ==================
 * public boolean hasnext()
 * public Object next()
 * public int nextIndex()
 * 
 * backward movement
 * ==================
 * public boolean hasPrevious()
 * public Object previous()
 * public int previousIndex()
 * 
 * extra Operation
 * ====================
 * public void remove()
 * public void add(Object o)
 * public void set(Object o)
 * @author purusingh
 *
 */
public class List_Iterator_Demo {

	/**
	 * main points
	 * ============
	 * 1.listiterator either it can move forward direction or backward direction and also it is a bidirectional cursor.
	 * 2.using listiterator we can perform REPLACEMENT AND ADDITION OF NEW OBJECT IN ADDITION TO READ AND REMOVE OPERATION.
	 * READ OPERATION
	 * REMOVE OPERATION
	 * REPLACEMENT OPERATION
	 * ADDITION OPERATION
	 * 
	 * !list iterator is a child interface of iterator(I) and all method present in iterator by defauilt present in list iterator.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		LinkedList l=new LinkedList();
		l.add("balakrishna");
		l.add("singh");
		l.add("dipu");
		l.add("puru");
		System.out.println(l);//[balakrishna, singh, dipu, puru]
		
		ListIterator itr=l.listIterator();
		while(itr.hasNext())
		{
			String s=(String) itr.next();
			
			if(s.equals("singh"))
			{
				itr.remove();//[balakrishna, dipu, puru]
			}
			else if(s.equals("puru"))
			{
				itr.add("singh");//[balakrishna, dipu, puru, singh]
			}
			else if(s.equals("dipu"))
			{
				itr.set("raaj");//[balakrishna, raaj, puru, singh]
			}
		}
		System.out.println(l);//[balakrishna, raaj, puru, singh]
		
	}

}
