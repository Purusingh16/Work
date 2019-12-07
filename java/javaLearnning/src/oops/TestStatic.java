package oops;

public class TestStatic {

	static String name="Purushottam";
	String lastName="kumar";
	
	static void print(){
		System.out.println("static print");
		System.out.println("name");
		//display();
	}
	void display(){
		print();
		System.out.println(name);
		System.out.println("instance level method");
	}
	public static void main(String[] args) {
		

	}

}
