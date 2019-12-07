package project3;

public class Person {

	String firstName = "dipu";
	String lastName = "kumar";
	int age;

	public void printfirstName() {
		System.out.println("first name is:" + firstName);
	}

	public void printlastName() {
		System.out.println("last name is:" + lastName);
	}

	public void printage(int a) {
		age = a;

		if (age < 20) {
			System.out.println("young");
		} else if (age > 40) {
			System.out.println("old");

		}
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.printfirstName();

		Person p2 = new Person();
		p2.printlastName();

		Person p3 = new Person();
		p3.printage(15);
		p3.printage(45);

	}
}
