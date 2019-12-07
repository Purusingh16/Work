package overriding;

public class Base 
{
	int i;//0
	
	public void increament()
	{
		i++;//
	}
	Base()
	{
		i++;
		increament();
	}

}
