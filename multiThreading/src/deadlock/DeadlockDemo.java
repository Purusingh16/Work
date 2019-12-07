package deadlock;

public class DeadlockDemo extends Thread 
{
	A a=new A();
	B b=new B();
	
	public void m1()
	{
		this.start();
		a.d1(b);//main thread
	}
	@Override
	public void run() 
	{
		super.run();
		b.d2(a);//child thread
	}
	
	public static void main(String args[])
	{
		DeadlockDemo d=new DeadlockDemo();
		d.m1();
		
		
	}

}
