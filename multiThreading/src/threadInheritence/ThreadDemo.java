package threadInheritence;

public class ThreadDemo {

	public static void main(String[] args) 
	{
		MyThread tt=new MyThread();
		Thread t1=new Thread(tt);
		t1.start();
		System.out.println("main thread");

	}

}
