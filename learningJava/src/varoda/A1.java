package varoda;

public class A1 
{

	public static void main(String[] args) 
	{
		System.out.println((Object)null);//If you call System.println(null) there are multiple candidate methods (with char [], String and Object argument) and the compiler can't decide which one to take.


	}

}
