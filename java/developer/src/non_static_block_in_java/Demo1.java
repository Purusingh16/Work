package non_static_block_in_java;

public class Demo1 
{
int data;
	
	
	/*
	 * Execution flow in this program:-
	 * For object dd
	 * 1. First non-static block
	 * 2. Second non-static block
	 * 3. Constructor
	 * 4. main method's system.out.println() statement
	 * For object aa
	 * 5. First non-static block
	 * 6. Second non-static block
	 * 7. Constructor
	 * 8. increment() method
	 * 9. main method's system.out.println() statement
	 */
	
	void increment()
	{
		data++;
	}
	
	//non static blocks will be executed before the execution of constructor
	
	//(execution order no:- 3)
	Demo1()
	{
		data+=3;
		System.out.println("Constructor block:- "+data);
	}
	
	
	//Order of execution of non static blocks will be order as they are defined.
	
	//First non-static block (execution order no:- 1)
	{
		
		data+=5;
		System.out.println("First non-static block:- "+data);
	}
	public static void main(String[] args)
	{
		Demo1 dd=new Demo1();
		
		//below statement (execution order no:- 4)
		System.out.println("main method after creating first object:- "+dd.data);
		
		Demo1 aa=new Demo1();
		aa.increment();
		System.out.println("main method after creating second object:- "+aa.data);
		
	}
	
	//Second non-static block (execution order no:- 2)
	{
		data+=5;
		System.out.println("second non-static block:- "+data);
	}

}