package command_line_args;

public class Command 
{
	public static void main(String[] args)
	{
		int size=args.length;
		System.out.println("\n see the command line argument");
		for (int i = 0; i < size; i++)
		{
			System.out.println(args[i]);
		}
		
	}

}
