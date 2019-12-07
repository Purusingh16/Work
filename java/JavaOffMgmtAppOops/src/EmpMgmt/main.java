package EmpMgmt;

public class main 
{
	public static void main(String[] args) 
	{
		/*Employee.compName = "IBM";*/
		//System.out.println(Employee.compName);
		// Employee.compName = "IBM Tech";
		
//		System.out.println("employee count="+Employee.empCount);
		System.out.println(Employee.getEmployeeCount());
		
		System.out.println(Employee.GetCompName());
		Employee.SetCompName("IBM Software");
		
		Employee e1=new Employee();
		System.out.println(e1.GetEmpInfo());
		
		Employee e2 = new Employee();
		System.out.println(e2.GetEmpInfo());
		
		Employee e3 =new Employee(301,"ramesh", 4360.56);
		System.out.println(e3.GetEmpInfo());
		
		Employee e4 =new Employee(401,"hghgh", 4360.56);
		System.out.println(e4.GetEmpInfo());
		
		e2.setEmpInfo(222,"dipak",5300.67);
		System.out.println(e2.GetEmpInfo());
		
		e3.setEmpInfo(301,"ramesh Roy",4365.45);
		System.out.println(e3.GetEmpInfo());
		
		//System.out.println(Employee.compName);
		System.out.println(Employee.GetCompName());
		
//		System.out.println("employee count="+Employee.empCount);
		System.out.println(Employee.getEmployeeCount());
	}
}
