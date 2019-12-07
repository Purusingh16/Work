package javaApp;

public class Student1 
{
	String name;
	int rollno;
	
	public Student1(String name,int rollno)
	{
		this.name=name;
		this.rollno=rollno;
	}
	public boolean equals(Object obj) 
	{
		try
		{
//		String name1=this.name;
//		int rollno1=this.rollno;
		
		Student1 student1=(Student1)obj;
		
//		String name2=student1.name;
//		int rollno2=student1.rollno;
		
		if (name.equals(student1.name) && rollno==student1.rollno	)
		{
			return true;
		}
		else
		{
			return false;
		}
		}
		catch (ClassCastException e) 
		{
			return false;
		}
		catch (NullPointerException e) 
		{
			return false;
		}
	}
	public static void main(String[] args) 
	{
		Student1 s1=new Student1("ravi", 101);
		Student1 s2=new Student1("depak", 102);
		Student1 s3=new Student1("ravi", 101);
		Student1 s4=s1;
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals(s4));
		System.out.println(s1.equals("ravi"));
		System.out.println(s1.equals(null));
		
	}

}
