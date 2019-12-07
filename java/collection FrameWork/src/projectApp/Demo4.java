package projectApp;

import java.util.LinkedList;

public class Demo4
{
	public static void main(String[] args)
	{
		LinkedList<String> l1=new LinkedList<String>();
        l1.add("C");
        l1.add("C++");
        l1.add("Java SE");
        l1.addFirst("Java EE");
        l1.add("Java ME");
        l1.addLast("ASP.Net");

        String first=(String)l1.getFirst();
        String last=(String)l1.getLast();
        System.out.println("First element is "+first);
        System.out.println("Last element is "+last);

        l1.removeFirst();
        l1.removeLast();
        l1.addLast(last);
        int size=l1.size();
        for(int i=0;i<size;i++)
                {
                String element=(String)l1.get(i);
                System.out.println("Elements are "+element);
                }
	}

}
