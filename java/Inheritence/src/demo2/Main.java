package demo2;

public class Main
{
	public static void main(String[] args)
	{
		Y ab=new Y();
		Y ab1=new Y();
		ab.display();
		ab.i=10;
		ab.i=50;
		ab1.i=100;
		ab.i=20;
		System.out.println(ab.i);
	}

}
