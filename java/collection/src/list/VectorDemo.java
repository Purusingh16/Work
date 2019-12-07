package list;

import java.util.Vector;

public class VectorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Vector v=new Vector();
		System.out.println(v.capacity());//10
		for (int i = 1; i <=10; i++)
		{
			v.addElement(i);
		}
		System.out.println(v);
		v.addElement("A");
		System.out.println(v.capacity());
		System.out.println(v);//[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, A]
	}

}
