package projectApp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Text 
{
	public static void main(String[] args)
	{
		HashMap<Integer, String> h=new HashMap<Integer, String>();

        h.put(new Integer(1), new String("Java"));  //key,value
        h.put(new Integer(2), new String(".Net"));
        h.put(new Integer(3), new String("C++"));
        h.put(new Integer(4), new String("C"));

        Set<Integer> ss=h.keySet();  //method of HashMap. return is object of Set interface. keys are retrieved from HashMap and stored in the set
        System.out.println("\nSee the key and the value\n");
        Iterator<Integer> ii=ss.iterator();
        while(ii.hasNext())
                {
                Integer key=(Integer)ii.next();  //Integer as key is an object. this method gives the key.
                String value=(String)h.get(key);  //this method gives the value
                System.out.print("\nKey is "+key+"\t Value is "+value);
                }
	}

}
