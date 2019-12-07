package dynamic_method_dispatch1;

public class Main
{

	public static void main(String[] args) 
	{
		Object ob1=new Base(100);
		System.out.println(ob1);
		
		Object ob2=new Child(100);
		System.out.println(ob2);
	}

}
