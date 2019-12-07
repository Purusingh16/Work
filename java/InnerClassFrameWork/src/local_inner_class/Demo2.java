package local_inner_class;

public class Demo2 
{
	

	public static void main(final String[] args)
	{
		class Inner
		{
			public void print()
			{
				int size=args.length;
				
				for (int i = 0; i < size; i++)
				{
					System.out.println(args[i]);
					
				}
			}
		}
		Inner obj=new Inner();
		obj.print();
	}

}
