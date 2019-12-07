package interfaceProject2;

public class Task implements B {

	@Override
	public void display() {
		System.out.println("interface demo");
	}

	@Override
	public void show() {
		System.out.println("java application");
	}

	public static void main(String[] args) {
		A ab;
		ab=new Task();
		ab.display();
		((B) ab).show();
	}

}
