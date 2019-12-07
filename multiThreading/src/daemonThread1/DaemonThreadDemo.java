package daemonThread1;

public class DaemonThreadDemo {

	public static void main(String[] args) 
	{
		MyThread d=new MyThread();
		d.setDaemon(true);
		d.start();
		System.out.println("end of main");
		
	}

}
