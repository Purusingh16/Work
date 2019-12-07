package overloaded;

public class Utility 
{
	String name;
	int number;
	public int Add(int n1)
	{
		return n1;
	}
	public int Add(int n1, int n2)
	{
		return n1+n2;
	}
	public int Add(int n1, int n2, int n3)
	{
		return n1+n2+n3;
	}
	public double Add(double n1,double n2)
	{
		return n1+n2;
	}
	public String Add(String s1,String s2)
	{
		return s1+s2;
	}
	
	public void setInfo(String name,int number)
	{
		this.name=name;
		this.number=number;
	}
	public void setInfo(int number, String name)
	{
		this.name=name;
		this.number=number;
	}
	public int Add(int[] arr )
	{
		int sum=0;
//		for (int i : arr) 
//		{
//			sum = sum+i;
//		}
		for (int i = 0; i < arr.length; i++) {
			sum = sum+ arr[i];
		}
		return sum;
	}
}
