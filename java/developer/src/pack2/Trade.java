package pack2;

public class Trade 
{
	protected String trade;
	
	protected String getTrade(String s)
	{
		Roll r=new Roll();
		System.out.println("ROll number is:"+r.getRoll(15));
		
		trade=s;
		return trade;
	}

}
