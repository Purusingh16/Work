package projectApp;

import java.util.Vector;

public class Demo3 
{
	public static void main(String[] args)
	{
		Vector<String> v1=new Vector<String>();
        v1.add("Java");
        v1.add(".Net");
        v1.add("Oracle");
        for(Object obj : v1)  //for-each loop
                {
                System.out.println(obj);
                }
	}

}
