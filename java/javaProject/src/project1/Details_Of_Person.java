package project1;

public class Details_Of_Person 
{
	
	public static void main(String[] args)
	{
		 
		Person.subject();
		System.out.println(Person.getSubject());
		Person p1=new Person();
		System.out.println(p1.getpersonInfo());
		
		Person p2=new Person("manoj", 25);
		System.out.println(p2.getpersonInfo());
		
		Student s1=new Student("depak",18,5000.00,101);
		System.out.println(s1.getpersonInfo());
		
		Teacher t1=new Teacher("ritesh",30,8000.00);
		System.out.println(t1.getpersonInfo());
		
		
	}

}
