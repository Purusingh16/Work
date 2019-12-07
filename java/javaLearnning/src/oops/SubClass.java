package oops;

public class SubClass extends SuperClass {
	int i=20;
	public SubClass() {
		super(10);
		System.out.println("This is Subclass");

	}
	public int print(){
//		int i=0;
		System.out.println(super.i);
		super.print("hello");
		System.out.println("in static");
		return 20;
	}

}
