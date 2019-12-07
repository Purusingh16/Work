package javaAssignment;

public class PrimeNum {

	public static void main(String[] args) {

		int limit = 100;
		boolean isprime = true;
		System.out.println("prime number bet 1 to 100");

		for (int i = 1; i < 100; i++) {

			isprime = true;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isprime = false;
					break;
				}

			}
			if (isprime)
				System.out.println(i + " is prime number");
			else
				System.out.println(i + " is not a prime number");
		}

	}
}