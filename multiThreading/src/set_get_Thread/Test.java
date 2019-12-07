package set_get_Thread;

public class Test 
{

	public static void main(String[] args) 
	{
		
		System.out.println(Thread.currentThread().getName());//main
		MyThread t=new MyThread();
		System.out.println(t.getName());//Thread-0
		Thread.currentThread().setName("multithreading");
		System.out.println(Thread.currentThread().getName());
		System.out.println(10/0);
	}

}
