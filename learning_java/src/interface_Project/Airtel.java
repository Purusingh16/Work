package interface_Project;

public class Airtel implements Sim 
{
	@Override
	public void call() {
		System.out.println("Calling using Airtel!!");
	}
	@Override
	public void sms() {
		System.out.println("sending message using Airtel!!");
	}
	@Override
	public void videoCall() {
		System.out.println("optional in subclass!!! default method");
		Sim.super.videoCall();
	}

}
