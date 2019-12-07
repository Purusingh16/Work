package sortedMap;

public class Temp 
{
	int i;
	
	Temp(int i)
	{
		this.i=i;
	}
	@Override
	public int hashCode() 
	{
		return i;
//		return i%9;
	}
	@Override
	public String toString()
	{
		return i+" ";
	}

}
