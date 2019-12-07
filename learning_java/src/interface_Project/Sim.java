package interface_Project;

/**
 * @author purusingh
 *
 */
public interface Sim 
{
	
	public abstract void call();
	public abstract void sms();
	public default void videoCall()
	{
		System.out.println("default method in interface!!!");
	}

}
 