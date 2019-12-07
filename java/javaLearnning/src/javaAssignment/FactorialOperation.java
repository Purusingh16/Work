package javaAssignment;

public class FactorialOperation {

	
	public static void main(String[] args) {
		int i,fact=1;
		int Number=5;
		for(i=1;i<=Number;i++)
		{
			fact=fact*i;
		}
		System.out.println("factorial "+Number+" is:"+fact);
	}

}
