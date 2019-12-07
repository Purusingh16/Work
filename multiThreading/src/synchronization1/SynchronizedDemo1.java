package synchronization1;

public class SynchronizedDemo1
{

	public static void main(String[] args)
	{
		Display d=new Display();
		MyThread t1=new MyThread(d);
		MyThread1 t2=new MyThread1(d);
		t1.start();
		t2.start();
	}

}
