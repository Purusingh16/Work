package abstractpack;

public class Y extends Stud 
{
	public Y()
	{
		super("singh", 25);
	}

	@Override
	public String getName() 
	{
		return name;
	}

	@Override
	public int getRoll() 
	{
		return roll;
	}

}
