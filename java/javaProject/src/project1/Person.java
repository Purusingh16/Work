package project1;

public class Person 
{
	private String name;
	private int age;
	 static String[] subject;
	
	static
	{
		String[] s={"servlet","core java","android"};
		System.out.println(s);
	}
	
public Person()
{
	this.name="sanker";
	this.age=25;
}
public Person(String name,int age)
{
	this.age=age;
	this.name=name;
}
public void setpersonInfo(String name,int age)
{
	this.age=age;
	this.name=name;
}
public String getpersonInfo()
{
	return "personInfo:"+this.age+" "+this.name+" "+subject;
}
public static void setSuject(String[] sub)
{
	subject=sub;
}
public static String[] getSubject()
{
	return subject;
}
public static void subject() {
	// TODO Auto-generated method stub
	
}
}
