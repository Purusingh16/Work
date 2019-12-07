package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SecondHighestElement {

	public static void main(String[] args)
	{
		Integer[] intarr={2 , 4 , 7 , 6, 9};
		
		ArrayList<Integer>  intarrlist=new ArrayList<Integer>(Arrays.asList(intarr));
		
		Collections.sort(intarrlist);
		
		System.out.println(intarrlist.get(intarr.length-2));

	}

}
