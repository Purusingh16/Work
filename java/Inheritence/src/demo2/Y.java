package demo2;

public class Y extends X
{
	@Override
	public void increment()
	{
		i+=10;
//		super.increment();
	}
	void display()
	{
		increment();
		super.increment();
		System.out.println("value of x is:"+i);
	}
	

}
