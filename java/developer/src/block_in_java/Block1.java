package block_in_java;
class X
{
	static int i;
	
	static 
	{
		i++;
		System.out.println(X.i);
	}
}
public class Block1
{
	static 
	{
		System.out.println("I am in block1 class");
	}

	public static void main(String[] args)
	{
		System.out.println("I am in main");
	}

}
