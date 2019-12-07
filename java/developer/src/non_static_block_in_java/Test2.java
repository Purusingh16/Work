package non_static_block_in_java;

public class Test2
{
	static final int a;
	public static void main(String[] args) 
	{
		System.out.println(a);
	}
	static 
	{
		a=12;
	}

}
