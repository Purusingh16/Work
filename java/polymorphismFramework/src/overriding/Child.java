package overriding;

public class Child extends Base 
{
	Child()
	{
		i++;
		increament();
	}
	public void increament()
	{
		i+=5;
		System.out.println("child class:"+i);
	}

}
