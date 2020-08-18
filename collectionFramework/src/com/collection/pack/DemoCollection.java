package com.collection.pack;

import java.util.*;

public class DemoCollection {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of Emplyees");
		Employee e[]=new Employee[5];
//		for(int i=0;i<e.length;i++)
//		{
			
//			System.out.println("Enter no. of employee skills");
//			String []s=new String[sc.nextInt()];
//			for(int j=0;j<s.length;j++)
//				s[j]=sc.next();
//			
//			System.out.println("Enter id,name and basic");
			e[0]=new Employee(2,"abc2",1234, "c","cpp");
			e[1]=new Employee(12,"abc3",1234, "c","cpp");
			e[2]=new Employee(10,"abc",1234, "c","cpp");
			e[3]=new Employee(100,"ac2",1234, "c","cpp");
			e[4]=new Employee(1,"a2",1234, "c","cpp");
//		}
		
		DemoList.printList(e);
		
		
		

	}

}
