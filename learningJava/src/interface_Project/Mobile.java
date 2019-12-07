package interface_Project;

public class Mobile 
{
	void insertSim(Sim sim)
	{
		sim.call();
		sim.sms();
		sim.videoCall();
	}

}
