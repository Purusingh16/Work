package local_inner_class;

public class Demo 
{
	private String name="Purushottam";
	
	public void localInner(int a,int b)
	{
		final int i=a+b;
		
		class Inner//local inner class
		{
			public void print()
			{
				System.out.println("Name is:"+name);
				System.out.println("Final value is:"+i);
			}
		}
		Inner obj=new Inner();
		obj.print();
	}

	public static void main(String[] args) 
	{
		Demo dd=new Demo();
		dd.localInner(100, 200);

	}

}
