package oops;

public class Test {

	public static void main(String[] ags) {
		System.out.println("Hello");
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		// for(int index=0;index<4;index++)
		for (int index = 0; index < a.length; index++)
		// int index=0;
		// for(;index<a.length;)
		{
			if (index == 3)
				// break;
				continue;
			System.out.println(a[index]);
			// index++;
		}
		// System.out.println(a[0]);
		// System.out.println(a[1]);
		// System.out.println(a[2]);
		// System.out.println(a[3]);

	}

}
