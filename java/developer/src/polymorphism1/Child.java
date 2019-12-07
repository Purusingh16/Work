package polymorphism1;

public class Child extends Base 
{
	Child()
	{
		increment();
		i++;
	}
	@Override
	public void increment() 
	{
		super.increment();
		i+=10;
	}

}
