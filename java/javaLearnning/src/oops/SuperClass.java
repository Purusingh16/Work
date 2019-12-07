package oops;

public class SuperClass {
	 int i=0;
	public SuperClass() {
		// i=value;
		this(10);
		System.out.println("This is superclass");
	}

	public SuperClass(int value) {
		System.out.println("SuperClass Value:" + value);
	}

	public void print(String value) {
		System.out.println(value);
		System.out.println(i);
	}

	public int print() {
		System.out.println("This is method");
		this.print("using this for methods");
		return 10;

	}

}
