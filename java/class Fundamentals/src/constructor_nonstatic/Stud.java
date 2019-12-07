package constructor_nonstatic;

public class Stud 
{
	String name;
	int roll;
	
	public Stud()
	{
		System.out.println("object is constructed");
	}
	public Stud(String s)
	{
		name=s;
	}
	public Stud(String n,int r)
	{
		name=n;
		roll=r;
	}
	public static void main(String[] args)
	{
		Stud s1=new Stud();
		Stud s2=new Stud("java");
		Stud s3=new Stud("dipu",101);
		
		System.out.println("Name is:"+s1.name+"\tRoll number is:"+s1.roll);
		System.out.println("Name is:"+s2.name+"\tRoll number is:"+s2.roll);
		System.out.println("Name is:"+s3.name+"\tRoll number is:"+s3.roll );
		
	}

}
