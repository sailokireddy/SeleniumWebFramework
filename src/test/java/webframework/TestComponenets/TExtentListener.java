package webframework.TestComponenets;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import webframework.resources.ExtentReporterNG;

public class TExtentListener extends BaseTest implements ITestListener{
	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extenttest=new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		//ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL, "Test Failed");
		extenttest.get().fail(result.getThrowable());
		test.fail(result.getThrowable());
		//Screenshot
		String filepath=null;
		try {
		driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			filepath=takescreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
	}

	
	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	
}
