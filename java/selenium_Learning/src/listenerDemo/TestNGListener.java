package listenerDemo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener 
{

	@Override
	public void onFinish(ITestContext Context) 
	{
		
	
	}

	@Override
	public void onStart(ITestContext Context)
	{

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result) 
	{

	}

	@Override
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("testcase failed and details are:"+Result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult Result) 
	{
		System.out.println("testcase skipped and details are:"+Result.getName());
	}

	@Override
	public void onTestStart(ITestResult Result)
	{
		System.out.println("testcase started and details are:"+Result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("testcase Success and details are:"+Result.getName());
	}

}
