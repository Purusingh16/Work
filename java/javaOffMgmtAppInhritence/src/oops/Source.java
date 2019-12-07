package oops;

public class Source 
{
	public static void main(String[] args)
	{
		SalesPerson sp=new SalesPerson(111, "aaaaa", 1000.75, 10, 50);
		System.out.println(sp.GetEmpInfo());
		System.out.println("Salary=" + sp.CalSal());
		
		Engineer en=new Engineer(112,"jack", 5000.85, 6, 600);		
		System.out.println(en.GetEmpInfo());
		System.out.println("Salary=" + en.CalSal());
		
		Manager mg=new Manager(501, "tom", 7000.95, 500);
		System.out.println(mg.GetEmpInfo());
		System.out.println("Salary=" + mg.CalSal());
		
		Employee employee=new Engineer(123, "sam", 4000, 6, 200);
		
//		Engineer engineer=new Employee(12, "don", 3000);
	}
	

}
