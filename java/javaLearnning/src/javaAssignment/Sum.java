package javaAssignment;

public class Sum {
	
	public static void main(String[] args) {
		int[] i = { 2, 4, 3, 1 };
		int Sum=0;
		for (int index = 0; index < i.length; index++) {
			Sum = Sum + i[index];
		}
System.out.println(Sum);
	}
}
