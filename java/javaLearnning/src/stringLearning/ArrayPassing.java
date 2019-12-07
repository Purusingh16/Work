package stringLearning;

public class ArrayPassing {

	
	public static void main(String[] args) {
		
		int a[]={1,2,3,4};
		int b[]={10,20,30,40,50};
		printArray(a);
		printArray(b);

	}
public static void printArray(int arr[])
{
	System.out.println("element are:");
	for(int i=0;i<arr.length;i++){
		System.out.print(arr[i]+" ");
	}
}
}
