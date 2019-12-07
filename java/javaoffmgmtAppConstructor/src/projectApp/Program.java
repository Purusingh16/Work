package projectApp;

public class Program 
{
	public static void main(String[] args)
	{
//		Teacher.schoolName="d.a.v";
//		System.out.println(Teacher.schoolName);
//		Teacher.schoolName="oxford";
//		System.out.println(Teacher.schoolName);
		
		System.out.println("Teacher count="+Teacher.count);
		
		System.out.println(Teacher.GetschoolName());
		Teacher.SetschoolName("IIT");
		
		Teacher t1=new Teacher();
		t1.SetTeacherInfo(501,"tom",5890.56);
		System.out.println(t1.GetTeacherInfo());
		
		Teacher t2=new Teacher(101,"jack",468.56);
		System.out.println(t2.GetTeacherInfo());
		
		Teacher t3=new Teacher(t2);
		System.out.println(t3.GetTeacherInfo());
		
		System.out.println("Teacher count="+Teacher.count);
		
	}
 	public static void main2(String[] args) 
	{
		/*Pen.brandName="parker";
		System.out.println(Pen.brandName);
		Pen.brandName="new parker";*/
		
		System.out.println(Pen.GetbrandName());
		Pen.SetbrandName("Cello");
		
		Pen p1=new Pen();
		p1.setPenInfo(5.5,34.67,"red");
		System.out.println(p1.getPenInfo());
		
		Pen p2=new Pen();
		System.out.println(p2.getPenInfo());
		
		Pen p3=new Pen(2.34,101.50,"black");
		System.out.println(p3.getPenInfo());
		
		Pen p4 = new Pen(p3);
		System.out.println(p4.getPenInfo());
		
		Pen p5=new Pen(p2);
		System.out.println(p5.getPenInfo());
	}
	
	public static void main1(String[] args) 
	{
		/*Employee.compName = "IBM";*/
		//System.out.println(Employee.compName);
		// Employee.compName = "IBM Tech";
		System.out.println(Employee.GetCompName());
		Employee.SetCompName("IBM Software");
		
		Employee e1=new Employee();
		System.out.println(e1.GetEmpInfo());
		
		Employee e2 = new Employee();
		System.out.println(e2.GetEmpInfo());
		
		Employee e3 =new Employee(301,"ramesh", 4360.56);
		System.out.println(e3.GetEmpInfo());
		
		e2.setEmpInfo(222,"dipak",5300.67);
		System.out.println(e2.GetEmpInfo());
		
		e3.setEmpInfo(301,"ramesh Roy",4365.45);
		System.out.println(e3.GetEmpInfo());
		
		//System.out.println(Employee.compName);
		System.out.println(Employee.GetCompName());
		
		
	}
}
