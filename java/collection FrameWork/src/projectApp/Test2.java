package projectApp;

import java.util.Enumeration;
import java.util.Vector;

public class Test2
{
	public static void main(String[] args) 
	{
		Vector<String> v1=new Vector<String>();

        v1.add("India");
        v1.add("China");
        v1.add("Russia");

        System.out.println("\nTraverse the elements\n");

        Enumeration<String> ee=v1.elements();
        while(ee.hasMoreElements())
                {
                String s=(String)ee.nextElement();
                System.out.print(s+"\t");
                }
        System.out.println("");
	}

}
