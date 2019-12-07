package variableTest;

public class Stud 
{
	String name;
	int roll;
	
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name=n;
	}
	public int getRoll()
	{
		return roll;
	}
	public void setRoll(int r)
 	{
		roll=r;
	}
	
	public static void main(String[] args)
	{
		Stud s=new Stud();
		s.setName("singh");
		s.setRoll(11);
		System.out.println("Name is:"+s.getName()+"\t Roll number is:"+s.getRoll());
		
		Stud ss=new Stud();
		System.out.println("Name is:"+ss.getName()+"\t Roll number is:"+ss.getRoll());
	}
	
		
}
