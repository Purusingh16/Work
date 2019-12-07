package demo;

public class B extends A
{
	int i;
	B(int a,int b)
	{
		super.i=a;
		this.i=b;
		System.out.println("learn java");
	}
	void display()
	{
		System.out.println(super.i+"\t"+i);
	}

}
