package projectApp;

import java.util.Random;

public class Teacher 
{
	 private int id;
	 private String name;
	 private double salary;
	 public static int count;
	 private static String schoolName;
	
	 static 
	 {
		 schoolName="pune university";
		 count=100;
	 }
//	 Initialization block
	 {
		 Random r=new Random();
		 this.id=r.nextInt(500);
		 count++;
	 }
	public Teacher()
	{
		System.out.println("default constructor called...");
//		this.id=101;
		this.name="jack";
		this.salary=4560.46;
	}
	public Teacher(int id,String name,double salary)
	{
		System.out.println("parametrized constructor called...");
//		this.id=id;
		this.name=name;
		this.salary=salary;
		
	}
	public Teacher(Teacher t)
	{
		System.out.println("copy constructor called...");
		this.id=t.id;
		this.name=t.name;
		this.salary=t.salary;
	}
	public void SetTeacherInfo(int id,String name,double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	public String GetTeacherInfo()
	{
		return "teacherInfo="+this.id+" "+this.name+" "+this.salary+" "+schoolName;
	}
	public static void SetschoolName(String sn)
	{
		schoolName=sn;
	}
	public static String GetschoolName()
	{
		return schoolName;
	}
}
