package second_way_of_developing_array_program;
//Third way way developing array
public class ArrayTest1
{
	int arr[];//declaration
	
	ArrayTest1()
	{
		arr=new int[]{56,87,98,90,36};
	}
	void display()
	{
		int size=arr.length;
		System.out.println("\nsee the element");
		for (int i = 0; i < size; i++) 
		{
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args)
	{
		ArrayTest1 at=new ArrayTest1();
		at.display();
	}

}
