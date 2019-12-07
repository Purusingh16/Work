package second_way_of_developing_array_program;

public class ArrayTest 
{
	public static void main(String[] args)
	{
//		declaration,construction and initialization in the same line
		int arr[]={78,29,34,45,99};
		int size=arr.length;
		for (int i : arr)
		{
			System.out.println(i);
		}
	}

}
