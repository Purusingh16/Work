package javaAssignment;

public class Second_Largest_Element {

	
	public static void main(String[] args) {
		int a[]={1,8,11,55,48};
		int largest=a[0];
		int second_l=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>largest)
			{
				second_l=largest;
				largest=a[i];
			}
			else if(a[i]>second_l && a[i]<largest)
			second_l=a[i];
		}
	
	System.out.println("second largest element:"+second_l);
	}
}
