package javaAssignment;
import java.util.*;
public class InputExample {

	
	public static void main(String[] args) {
		System.out.println("Enter your Name and Age:");
		Scanner sc=new Scanner(System.in);
		String name=sc.nextLine();
		int age=sc.nextInt();
		
		
		System.out.println("Name:"+name+" age:"+age);
	}

}
