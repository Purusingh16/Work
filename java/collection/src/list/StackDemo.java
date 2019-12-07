package list;

import java.util.Stack;

public class StackDemo {

	/**
	 * stack method
	 * 1.Object push(Object o) to insert an object into stack
	 * 2.Object pop() to remove and return top of the stack
	 * 3.Object peek() to return top of the stack without removal
	 *4.boolean empty() returns true if the stack is empty
	 * 5.int search(Object) returns offset if the element is available otherwise returns -1.
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Stack s=new Stack();
		s.push("A");
		s.push("B");
		s.push("C");
		System.out.println(s);//[A, B, C]
		System.out.println(s.search("A"));
		System.out.println(s.search("Z"));


		

	}

}
