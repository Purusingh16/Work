package interfaceApp;

public class Excel implements MsOffice
{

	@Override
	public void open() 
	{
		System.out.println("This is for open excel file");
	}

	@Override
	public void write()
	{
		System.out.println("This is for writing on excel file");
	}

	@Override
	public void save() 
	{
		System.out.println("This is for saving the excel file");
	}
	
}
