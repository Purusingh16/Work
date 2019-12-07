package constructor_nonstatic;

public class Test 
{
	String name;
	int roll;
	
	public void setName(String n)
	{
		name=n;
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
		Test tt=new Test();
		tt.setName("Purushottam");
		tt.setRoll(101);
		
		System.out.println("Name is:"+tt.getName()+"\tROll number is:"+tt.getRoll());
//		System.out.println("Name is:"+aa.getName()+"\tROll number is:"+aa.getRoll());
	 }

}
