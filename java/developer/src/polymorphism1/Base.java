package polymorphism1;

public class Base 
{
	int i;
	public void increment()
	{
		i++;
	}
	Base()
	{
		increment();
		i++;
	}
}
