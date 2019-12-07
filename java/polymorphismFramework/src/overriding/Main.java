package overriding;

public class Main 
{
	public static void main(String[] args) 
	{
		Base ab=new Child();
		ab.increament();
		System.out.println(ab.i);
	}

}
