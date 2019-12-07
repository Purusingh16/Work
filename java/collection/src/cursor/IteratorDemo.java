package cursor;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		ArrayList l=new ArrayList();
		for (int i = 0; i <=10; i++)
		{
			l.add(i);
		}
		System.out.println(l);
		Iterator itr=l.iterator();
		while(itr.hasNext())
		{
			Integer in=(Integer) itr.next();
			if(in%2==0)
				System.out.println(in);//[0, 2, 4, 6, 8, 10]
			
			else
				itr.remove();
		}
		System.out.println(l);//[0, 2, 4, 6, 8, 10]

	}

}
