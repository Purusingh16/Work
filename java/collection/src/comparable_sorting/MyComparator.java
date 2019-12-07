package comparable_sorting;

import java.util.Comparator;

public class MyComparator implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) 
	{
		Employee e1=(Employee) o1;
		Employee e2=(Employee) o2;
		
		String s1=e1.name;
		String s2=e2.name;
		
		return s1.compareTo(s2);
	}
	

}
