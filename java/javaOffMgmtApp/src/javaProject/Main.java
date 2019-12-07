package javaProject;

public class Main
{
	public static void main(String[] args) 
	{
		/*Employee e=new Employee();
		e.id=101;
		e.name="dipu singh";
		e.salary=3000;
		
		e.setEmpInfo(101,"dipusing", 300.456);
		System.out.println(e.GetEmpInfo());
		
		Employee e1=new Employee();
		e1.id=102;
		e1.name="ram kumar";
		e1.salary=5000.45;
	
		e1.setEmpInfo(102, "ram singh", 345.675);
		System.out.println(e1.GetEmpInfo());
		
		e1.GiveBonus(300);
		e.GiveBonus(400);
		
		System.out.println("salary of emp1:"+e.CalSal()+"INR");
		System.out.println("salary of emp2:"+e1.CalSal()+"INR");
		*/
		Person p1=new Person();
		/*p1.p_id=501;
		p1.p_name="rohan singh";
		p1.p_salary=4567.89;*/
		
		
		p1.setpersoninfo(201,"ram singh",3455.34);
		System.out.println(p1.getpersoninfo());
		
		p1.givebonus(505);
		
		System.out.println("salary of person1:"+p1.calSal()+"INR");
		
		
	}
	

}
