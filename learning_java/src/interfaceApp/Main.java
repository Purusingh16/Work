package interfaceApp;

public class Main implements Demo
{
	@Override
	public void add() 
	{
		System.out.println("this is unimplemented method!!!");
	}

	@Override
	public void subtract() 
	{
		System.out.println("this is unimplemented method!!!");
	}
	
	public static void main(String[] args) 
	{
		Main m=new Main();
		m.multiply();
		m.add();
		m.subtract();
		Demo.DoIt();
		
	}

	

}
