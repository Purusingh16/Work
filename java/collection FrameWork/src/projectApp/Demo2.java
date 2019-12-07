package projectApp;

import java.util.ArrayList;
import java.util.Vector;

public class Demo2 
{
	public static void main(String[] args)
	{
		ArrayList<Comparable> a1=new ArrayList<Comparable>();
        a1.add(new String("First"));
        a1.add(new Integer(1));
        a1.add(new Boolean("True"));

        Vector<Comparable> v1=new Vector<Comparable>();
        v1.add(new String("Java"));
        v1.add(new String("Oracle"));
        v1.add(new String("ASP.Net"));

        v1.addAll(a1);  //all the elements of ArrayList goes to the Vector. so now 6 elements in vector

        Object obj[]=v1.toArray();
        int size=obj.length;  //variable in Array class returns the size
        System.out.println("\nSee the elements.\n");
        for(int i=0;i<size;i++)
      	{		
              System.out.println(obj[i]);
        }

	}

}
