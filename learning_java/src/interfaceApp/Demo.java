package interfaceApp;

public interface Demo 
{
	final static int a=9;
	int b=10;
	
	void add();
	void subtract();
	
	default void multiply() 
	{
		System.out.println("default method in interface!!!");
	}
	 public static void DoIt()
	 {
		 System.out.println("static method in interface!!!");
	 }

}
