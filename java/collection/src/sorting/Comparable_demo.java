package sorting;

public class Comparable_demo {

	/**
	 * default natural sorting order.
	 * lang package
	 * comapareTo()--->method
	 * 
	 * public int compareTo(Object obj)
	 * 
	 * obj1.compareTo(obj2)
	 * 1.returns -ve if obj1 has to come before obj2
	 * 2.returns +ve if obj1 has to come after obj2
	 * 3.returns 0 if obj1 and obj2 are equal.
	 * @param args
	 */
	public static void main(String[] args)
	{
		System.out.println("A".compareTo("Z"));//-ve
		System.out.println("K".compareTo("A"));//+ve
		System.out.println("A".compareTo("A"));//0
		System.out.println("A".compareTo(null));//NPE

	}

}
