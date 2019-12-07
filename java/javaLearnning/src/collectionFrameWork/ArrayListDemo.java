package collectionFrameWork;
import java.util.ArrayList;
public class ArrayListDemo {

	
	public static void main(String[] args) 
	{
		ArrayList<Integer> arr=new ArrayList<Integer>();
		arr.add(23);
		arr.add(45);
		arr.add(56);
		
		arr.add(0,47);
		
		arr.remove(0);
		
		arr.clear();
		arr.add(23);
		
		ArrayList<Integer> arr_2=new ArrayList<Integer>();
		
		arr_2.add(45);
		arr_2.add(48);
		
		arr.addAll(arr_2);
		
		
		for(int index=0;index<arr.size();index++)
		System.out.println(arr.get(index));
		
		/*for(Integer value:arr)
		{
			System.out.println(value);
		}*/
		ArrayList<String> StrList=new ArrayList<String>();
		
	}

}
