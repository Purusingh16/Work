package javaApp;

public class Student
{
	String name;
	int rollno;
	
	public Student(String name,int rollno)
	{
		this.name=name;
		this.rollno=rollno;
	}
	public String toString()
	{
//		return name+" "+rollno;
		return "This is student with the name:"+name+" and rollno: "+rollno;
	}

	public static void main(String[] args)
	{
		Student student=new Student("ravi", 101);
		Student student2=new Student("pankaj", 102);
		System.out.println(student);//Student@659e0bfd
		System.out.println(student.toString());//Student@659e0bfd
		System.out.println(student2);//Student@2a139a55
	}

}
