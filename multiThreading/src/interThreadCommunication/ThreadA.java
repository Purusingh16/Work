package interThreadCommunication;

public class ThreadA {

	public static void main(String[] args) throws InterruptedException
	{
		ThreadB b=new ThreadB();
		b.start();
//		b.sleep(10000);
//		b.join();
		synchronized (b) 
		{
			System.out.println("main thread calling wait method");
			b.wait();
			System.out.println("main thread got notification call");
			System.out.println(b.total);
		}
		
	}

}
