package projectApp;

import java.util.Enumeration;
import java.util.Hashtable;

public class Text1 
{

	public static void main(String[] args) 
	{
		 Hashtable<Integer, String> h=new Hashtable<Integer, String>();

         h.put(new Integer(1), new String("Java"));
         h.put(new Integer(2), new String(".Net"));
         h.put(new Integer(3), new String("Oracle"));
         h.put(new Integer(4), new String("DBMS"));

         Enumeration<Integer> ee=h.keys();  //it is a legacy classes, so enumeration is used.

         System.out.println("\nSee the keys and values\n");

         while(ee.hasMoreElements())
                 {
                 Integer key=(Integer)ee.nextElement();
                 String value=(String)h.get(key);
                 System.out.println("Key is "+key+" Value is "+value);
                 }

	}

}
