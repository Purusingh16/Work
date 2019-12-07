package overloaded;

public class MyExp extends Exception {
	
	public MyExp()
	{
		super("My Exception generated !!!!");
	}
	
	public MyExp(String error)
	{
		super(error);
	}
	

}
