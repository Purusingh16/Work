package daemonThread;

public class Test {

	public static void main(String[] args) 
	{
		System.out.println(Thread.currentThread().isDaemon());//false
//		Thread.currentThread().setDaemon(true);
		MyThread d=new MyThread();
		System.out.println(d.isDaemon());//false
		d.setDaemon(true);
		System.out.println(d.isDaemon());
	}

}
