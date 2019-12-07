package projectApp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Test3 
{
	public Test3()
    {
    Collection<String> c=new ArrayList<String>();  //dynamic method dispatch
    c.add("Ayas");
    c.add("Aarav");
    c.add("Aalya");
    c.add("Aahna");
    c.add("Karan");
    c.add("Aalya");

    System.out.println("\nSee the elements of the list\n");
    Iterator<String> ii=c.iterator();
    while(ii.hasNext())
            {
            String name=(String)ii.next();
            System.out.print(name+"\t");
            }
    display1(c);  //HashSet
    display2(c);  //TreeSet
    }

void display1(Collection<String> a)
    {
    Collection<String> aa=new HashSet<String>(a);  //it should not contain duplicate elements but Aalya is duplicated in the a object.
    System.out.println("\nSee the elements of the Set\n");
    Iterator<String> ee=aa.iterator();
    while(ee.hasNext())
            {
            String s=(String)ee.next();
            System.out.print(s+"\t");
            }
    }

void display2(Collection<String> r)
    {
    Collection<String> tt=new TreeSet<String>(r);  //contain unique elements in sorted order.
    System.out.println("\nSee the elements of the SortedSet\n");
    Iterator<String> e=tt.iterator();
    while(e.hasNext())
            {
            String name=(String)e.next();
            System.out.print(name+"\t");
            }
    }

	public static void main(String[] args)
	{
		Test3 t=new Test3();
	}

}
