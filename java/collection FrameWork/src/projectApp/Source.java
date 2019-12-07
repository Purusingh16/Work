package projectApp;

import java.util.ArrayList;
import java.util.Iterator;

public class Source 
{
	public static void main(String[] args) 
	{
		ArrayList<Employee> list=new ArrayList<>();
		System.out.println(list.size());
		list.add(new Employee(501, "sunil", 1000));
		list.add(new Employee(501, "dheeraj", 2000));
		list.add(new Employee(503, "prashant", 3000));
		System.out.println(list.size());
//		System.out.println(list);
		System.out.println(list.get(1).getEmployeeInfo());
		list.add(1, new Employee(111, "saddsd", 2340));
		list.remove(3);
		
		System.out.println("list of emp");
		for (Employee emp : list) 
		{
			System.out.println(emp.getEmployeeInfo());
		}
		Iterator<Employee> iterator=list.listIterator();
		while (iterator.hasNext()) 
		{
			Employee employee = (Employee) iterator.next();
			System.out.println(employee.getEmployeeInfo());
			
		}
		
}
	public static void main2(String[] args) 
	{
		ArrayList<String> list=new ArrayList<>();
		System.out.println(list.size());
		list.add("kumar");
		list.add("dipu");
		list.add("singh");
		list.add("raaj");
		list.add(1,"deepak");
		System.out.println(list.size());
		//list.remove(1);
		//System.out.println(list);
		//list.remove("raaj");
		//System.out.println(list);
		System.out.println(list.get(2));
		
		System.out.println("list of String :"+list);
		Iterator<String> i=list.listIterator();
		
		while (i.hasNext()) 
		{
			String string = (String) i.next();
			System.out.println(string);
			
		}
	}
	
	public static void main1(String[] args) 
	{
		Employee employee=new Employee(101, "dipu", 2000);
		
		Employee[] elist=new Employee[3];
		elist[0] =new Employee(101, "kumar", 3000);
		elist[1] =new Employee(102, "singh", 4000);
		elist[2] =new Employee(103, "raju", 5000);
		
		for (int i = 0; i < elist.length; i++) 
		{
			System.out.println(elist[i].getEmployeeInfo());
			
		}
		/*for (Employee emp : elist)
		{
			System.out.println(emp.getEmployeeInfo());
			
		}*/
		}

}
