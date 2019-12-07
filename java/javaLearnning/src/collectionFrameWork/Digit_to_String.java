package collectionFrameWork;

import java.util.ArrayList;

public class Digit_to_String 
{

	
	public static void main(String[] args)
	{
		int num=547;
		int c=0;
		ArrayList<String> strlist=new ArrayList<String>();
		String[] s={"zero","one","two","three","four","five","six","seven","eight","nine"};
		while(num>0)
		{
			c=num%10;
			num=num/10;
//			System.out.println(s[c]+" ");
			strlist.add(s[c]);
			 
		}
		for(int i=strlist.size()-1;i>=0;i--)
		{
			System.out.println(strlist.get(i)+" ");
		}
		
	}

}
