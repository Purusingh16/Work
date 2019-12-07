package overloaded;

public class ApplyUtility 
{
	String name;
	int number;
	
	public int Add(int n1,int n2)
	{
		return n1+n2;
	}
	public int Add1(int n1,int n2,int n3)
	{
		return n1+n2+n3;
	}
	public double Add2(double n1,double n2)
	{
		return n1+n2;
	}
	public String Add_concat_String(String s1,String s2)
	{
		return s1+s2;
	}
	public void setInfo(String name,int number)
	{
		this.name=name;
		this.number=number;
	}
	public void setInfo(int number,String name)
	{
		this.name=name;
		this.number=number;
	}
}
