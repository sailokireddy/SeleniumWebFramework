package webframework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	
	public static ExtentReports getReportObject() {
		ExtentReports extent;
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter report=new ExtentSparkReporter(path);
		report.config().setDocumentTitle("My Extent Report Title");
		report.config().setReportName("Extent Report name");
		
		extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("QA1", "Sai Mahesh");
		return extent;
	}
}
