package interfaceProject;

public class Main extends A implements X,Y
{
	@Override
	public void show() 
	{
		System.out.println("calling interface X:"+"java");
	}
	@Override
	public void display()
	{
		System.out.println("calling interface X:"+"java application");
	}
	@Override
	public void fun()
	{
		System.out.println("calling interface Y:"+"learn java");
	}
	public static void main(String args[])
	{
		Main m=new Main();
		m.task();
		m.show();
		m.display();
		m.fun();
		System.out.println("calling parent instance variable:"+m.a);
	}
}
