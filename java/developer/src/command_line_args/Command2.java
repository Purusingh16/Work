package command_line_args;

public class Command2
{
	public static void main(String[] args) 
	{
		int i=0;
		int size=args.length;
		System.out.println(size);
		while(++i<size)
		{
			System.out.println(i);
			System.out.println(args[i]);
		}
	}

}
