package sorting;

import java.util.Comparator;


class My_Comparator implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
//		return +1;
//		return -1;
//		return 0;
//		return -I2.compareTo(I1);
	
		
		Integer I1=(Integer) o1;
		Integer I2=(Integer) o2;
//		return I1.compareTo(I2);
		if(I1<I2){
			return +1;
		}
		else if(I1>I2){
		return -1;
		}
		else{
		return 0;
		}
	} 
	
}
