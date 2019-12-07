package constructor;

public class Stud 
{
	String name;
	int roll;
	
	public void setName(String s)
	{
		name=s;
	}
	public String getName()
	{
		return name;
	}
	public void setRoll(int r)
	{
		roll=r;
	}
	public int getRoll()
	{
		return roll;
	}
	public static void main(String[] args)
	{
		Stud ss=new Stud();
		ss.setName("dipu");
		ss.setRoll(101);
		System.out.println("name is:"+ss.getName()+" roll num is:"+ss.getRoll());
		
		Stud ss1=new Stud();
		ss1.setName("dipu singh");
		ss1.setRoll(102);
		System.out.println("name is:"+ss1.getName()+" roll num is:"+ss1.getRoll());
	}

}
