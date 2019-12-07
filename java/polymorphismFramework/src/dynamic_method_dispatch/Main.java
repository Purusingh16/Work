package dynamic_method_dispatch;

public class Main 
{

	public static void main(String[] args)
	{
		Base bb;
		bb=new Child();
		bb.increament();
		System.out.println(bb.i);
	}

}
