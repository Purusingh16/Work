package project;

public class Main 
{

	public static void main(String[] args)
	{
		Student student=new Student(101, "tom", 60);
		System.out.println(student.getPersonInfo());
		
		System.out.println("total fees:"+student.payFees());
		
		Teacher teacher=new Teacher(102, "jack", 60);
		System.out.println(teacher.getPersonInfo());
		
		System.out.println("total salary:"+teacher.calSalary());
	}

}
