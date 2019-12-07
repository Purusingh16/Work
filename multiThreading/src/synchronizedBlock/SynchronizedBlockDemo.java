package synchronizedBlock;

public class SynchronizedBlockDemo
{

	public static void main0(String[] args)
	{
		Display d=new Display();
		MyThread t1=new MyThread(d, "dipu");
		MyThread t2=new MyThread(d, "purushottam");
		t1.start();
		t2.start();
		
	}
	public static void main(String[] args)
	{
		Display d1=new Display();
		Display d2=new Display();
		MyThread t1=new MyThread(d1, "dipu");
		MyThread t2=new MyThread(d2, "purushottam");
		t1.start();
		t2.start();
		
	}

}
