package synchronization;

public class SynchronizedDemo 
{

	public static void main(String[] args)
	{
		Display d1=new Display();
		Display d2=new Display();
		MyThread t1=new MyThread(d1,"java");
		MyThread t2=new MyThread(d2, "c++");
		t1.start();
		t2.start();
	}

}
