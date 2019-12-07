package interview;

class MyThread1 extends Thread
{
	public void run()
	{
		 for (int i = 1; i < 5; i++) 
		{
			 System.out.println("thread1 :"+i);
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			 {
				e.printStackTrace();
			}
			
		}
	}
	
}
class MyThread2 {
	public void run()
	{
		 for (int i = 11; i < 15; i++) 
		{
			 System.out.println("thread2 :"+i);
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) 
			 {
				e.printStackTrace();
			}
			
		}
	}
	
}
public class DemoThread
{

	public static void main(String[] args) 
	{
		MyThread1 obj1=new MyThread1();
		MyThread1 obj2=new MyThread1();
		System.out.println(obj1.currentThread());
		obj1.start();
		obj2.start();
//		obj1.run();
//		obj2.run();
		
		
	}

}
