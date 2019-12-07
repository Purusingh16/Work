package javaAssignment;

public class CommonElement {

	static int a1[]={1,3,4,5,6};
	static int a2[]={2,3,7,0,9};
	public static void main(String[] args) {
		
		for( int i=0;i<a1.length;i++)
		{
			for(int j=0;j<a2.length;j++)
			{
				if(a1[i]==a2[j])
				{
					System.out.println("common no."+a1[i]);
				}
			}
		}
	}

}
