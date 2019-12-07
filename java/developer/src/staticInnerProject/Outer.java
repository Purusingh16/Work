package staticInnerProject;

 class Test
{
	String name;
	String add;
	
	static class Inner
	{
		String getName(String s)
		{
			Test tt=new Test();
			tt.name=s;
			return s;
		}
	}
	static class Inner2 extends Inner
	{
		String getAddress(String s)
		{
			Test t=new Test();
			t.add=s;
			return s;
		}
	}

}
public class Outer
{
	public static void main(String[] args) 
	{
		Test.Inner2 ii=new Test.Inner2();
		System.out.println("Name is:"+ii.getName("dipu singh"));
		System.out.println("Address is:"+ii.getAddress("pune"));
		
	}

}
