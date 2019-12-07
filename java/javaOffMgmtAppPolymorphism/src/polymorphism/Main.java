package polymorphism;

import java.util.ArrayList;


public class Main 
{
	public static void main(String[] args)
	{
		ArrayList<Employee> elist = new ArrayList<>();
		elist.add(new SalesPerson(111, "Rebecca", 1000.75, 10, 50));
		elist.add(new Engineer(112,"jack", 5000.85, 6, 600));
		elist.add(new Manager(501, "tom", 7000.95, 500));
		elist.add(new SalesPerson(354, "Puru", 2300, 10, 10));
		elist.add(new Clerk(232,"Sham", 3000,2000));
		
		for (Employee e : elist) {	
			System.out.println(e.GetEmpInfo());
			System.out.println("Salary="+e.CalSal());
		}
	}
	public static void main3(String[] args)
	{
		Employee[] elist = new Employee[3];
		elist[0] = new SalesPerson(111, "Rebecca", 1000.75, 10, 50);
		elist[1] = new Engineer(112,"jack", 5000.85, 6, 600);
		elist[2] = new Manager(501, "tom", 7000.95, 500);
		
		for (int i = 0; i < elist.length; i++) {
			System.out.println(elist[i].GetEmpInfo());
		}
		
		System.out.println("*****************");
		
		for (Employee e : elist) {
			System.out.println(e.GetEmpInfo());
		}
	}
	public static void main2(String[] args)
	{
		Employee e1 =new SalesPerson(111, "Rebecca", 1000.75, 10, 50);
		System.out.println(e1.GetEmpInfo());
		System.out.println("Salary=" + e1.CalSal());
		
		Employee e2=new Engineer(112,"jack", 5000.85, 6, 600);		
		System.out.println(e2.GetEmpInfo());
		System.out.println("Salary=" + e2.CalSal());
		
		Employee e3=new Manager(501, "tom", 7000.95, 500);
		System.out.println(e3.GetEmpInfo());
		System.out.println("Salary=" + e3.CalSal());
	}
	public static void main1(String[] args)
	{
		SalesPerson sp=new SalesPerson(111, "Rebecca", 1000.75, 10, 50);
		System.out.println(sp.GetEmpInfo());
		System.out.println("Salary=" + sp.CalSal());
		
		Engineer en=new Engineer(112,"jack", 5000.85, 6, 600);		
		System.out.println(en.GetEmpInfo());
		System.out.println("Salary=" + en.CalSal());
		
		Manager mg=new Manager(501, "tom", 7000.95, 500);
		System.out.println(mg.GetEmpInfo());
		System.out.println("Salary=" + mg.CalSal());
	}

}
