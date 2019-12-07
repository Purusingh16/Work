package overlodedMethodDemo;

public class ThreadDemo {

	public static void main(String[] args)
	{
		MyThread t=new MyThread();
		t.start();
		System.out.println("main method");
	}

}
