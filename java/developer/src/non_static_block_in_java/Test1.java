package non_static_block_in_java;

public class Test1
{
	final int i;

	public static void main(String[] args)
	{
		Test1 tt=new Test1();
		System.out.println(tt.i);

	}
	{
		i=100;
	}

}
