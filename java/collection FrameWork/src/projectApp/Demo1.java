package projectApp;

import java.util.ArrayList;

public class Demo1 
{

	public static void main(String[] args) 
	{
		 ArrayList<String> a1=new ArrayList<String>(10);  //yet no elements is inserted so now size is 0.
         int size=a1.size();  //returns the size of the ArrayList
         System.out.println("Size before insertion is "+size);
         a1.add(("Java"));  //always takes object reference
         a1.add(new String("ASP.Net"));
         a1.add(new String("Oracle"));
         a1.add(new String("MySQL"));
         size=a1.size();
         System.out.println("Size after insertion is "+size);
         System.out.println("See the elements of the ArrayList");
         for(String str: a1)
                 {
//               String name=(String)a1.get(i);  //retrieves the object typecasted to string which takes the index as argument in integer value.
                 System.out.print(str+"\t");
                 }
	}

}
