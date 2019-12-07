package projectApp;

import java.util.ArrayList;
import java.util.Iterator;

public class Test 
{

	public static void main(String[] args)
	{
		ArrayList<String> a1=new ArrayList<String>();
        a1.add("India");
        a1.add("China");
        a1.add("Japan");
        a1.add("Russia");
        a1.add("Pakistan");

        System.out.println("\nUse Iterator to traverse the elements\n");
        Iterator<String> ii=a1.iterator();  //iterator() is method of Collection interface and is abstract and is overridden in child class (in ArrayList)
        while(ii.hasNext())
                {
                String country=(String)ii.next();
                System.out.println(country);
                }
	}

}
