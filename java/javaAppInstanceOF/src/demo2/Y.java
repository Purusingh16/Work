package demo2;

public class Y extends X 
{
	int j;

	Y fun(int a,int b)
	{
		i=a;
		j=b;
		return this;
	}
	Y display()
	{
		i++;
		j++;
		return this;
	}
}
