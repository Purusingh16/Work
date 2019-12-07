package interfaceApp;

public class Word implements MsOffice
{

	@Override
	public void open() 
	{
		System.out.println("This is for open word");
	}

	@Override
	public void write()
	{
		System.out.println("This is for writing word");
	}

	@Override
	public void save() 
	{
		System.out.println("This is for saving the word file");
	}

}
