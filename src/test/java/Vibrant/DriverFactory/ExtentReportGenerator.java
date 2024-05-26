package Vibrant.DriverFactory;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportGenerator {
	
	public static ExtentReports getExtentReport() {
	String path=System.getProperty("user.dir")+"//reports//index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
	reporter.config().setReportName("Web Automation");
	reporter.config().setDocumentTitle("Test Automation");
	

	
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester","Jagan");
	
	return extent;
	}

}
