package command_line_args;

public class Command3 
{

	public static void main(String[] args)
	{
		call(args);
	}
	static void call(String ss[])
	{
		int size=ss.length;
		for (int i = 0; i < size; i++)
		{
			System.out.println(ss[i]);
		}
	}

}
