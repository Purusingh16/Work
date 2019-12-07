package project;

import java.util.ArrayList;

public class Cal_Emp_Detail
{
	public static void main(String[] args)
	{
		ArrayList<Employee> elist=new ArrayList<>();
		elist.add(new FullTime("sima",45,'f', 50000.00, "senior manager", 10000.00));
		elist.add(new PartTime("suman",20, 'm', 23340.00, 12, 200));
		
		for (Employee e : elist) 
		{
			System.out.println(e.getEmpInfo());
			System.out.println("salary="+e.calSalary());
		}
	}
	public static void main3(String[] args)
	{
		Employee[] elist=new Employee[2];
		elist[0]=new FullTime("sima",45,'f', 50000.00, "senior manager", 10000.00);
		elist[1]=new PartTime("suman",20, 'm', 23340.00, 12, 200);
		
		for (int i = 0; i < elist.length; i++)
		{
			System.out.println(elist[i].getEmpInfo());
			System.out.println("salary="+elist[i].calSalary());
		}
		System.out.println("*********");
		for (Employee e : elist)
		{
			System.out.println(e.getEmpInfo());
			System.out.println("salary="+e.calSalary());
		}
	}
	public static void main2(String[] args)
	{
		Employee e1=new FullTime("sima",45,'f', 50000.00, "senior manager", 10000.00);
		System.out.println(e1.getEmpInfo());
		System.out.println("salary="+e1.calSalary());
		
		Employee e2=new PartTime("suman",20, 'm', 23340.00, 12, 200);
		System.out.println(e2.getEmpInfo());
		System.out.println("salary="+e2.calSalary());
	}
	public static void main1(String[] args) 
	{
		/*Employee.compName="IBM";
		Employee.setcompName("hsbc");
		System.out.println(Employee.compName);*/
		
		System.out.println(Employee.getcompName());
//		System.out.println(Employee.empCount);
		
		Employee e1=new Employee();
		e1.setEmpInfo("jack",18,'m',12550.00);
		System.out.println(e1.getEmpInfo());
		System.out.println("salary="+e1.calSalary());
		
		Employee e2=new Employee("depak",20,'m',4550.00);
		e2.setEmpInfo("sandeep",45,'m',20000.00);
		System.out.println(e2.getEmpInfo());
		System.out.println("salary="+e2.calSalary());
		
		Employee e3=new Employee(e2);
		System.out.println(e3.getEmpInfo());
				
		FullTime ft=new FullTime("sam",35,'m',25000.00,"manager",5000.00);
		System.out.println(ft.getEmpInfo());
		System.out.println("salary="+ft.calSalary());
		
		PartTime pt=new PartTime("priya",25,'f',20000.00,6,200);
		System.out.println(pt.getEmpInfo());
		System.out.println("salary="+pt.calSalary());
		System.out.println(Employee.empCount);
	}

	
}