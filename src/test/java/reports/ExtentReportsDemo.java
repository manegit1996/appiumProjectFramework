package reports;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;




public class ExtentReportsDemo {
	
	static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	@BeforeSuite
	public static void reportSetup() {
		
	htmlReporter = new ExtentHtmlReporter("extent.html");
	
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
		
	}
	
	@AfterSuite
	public static void reportTearDown() {
		
		extent.flush();
	}

}
