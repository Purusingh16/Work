package projectApp;

import java.util.ArrayList;
import java.util.ListIterator;

public class Test1
{

	public static void main(String[] args) 
	{
		 ArrayList<String> a1=new ArrayList<String>();
         a1.add("Java");
         a1.add(".Net");
         a1.add("Oracle");

         System.out.println("\nTraverse the elements in Forward direction\n");

         ListIterator<String> l1=a1.listIterator();
         while(l1.hasNext())
                 {
                 String s=(String)l1.next();
                 System.out.print(s+"\t");
                 }
         System.out.println("\nTraverse the elements in backward direction\n");
         while(l1.hasPrevious())
                 {
                 String s=(String)l1.previous();
                 System.out.print(s+"\t");
                 }
         System.out.println("");

	}

}
