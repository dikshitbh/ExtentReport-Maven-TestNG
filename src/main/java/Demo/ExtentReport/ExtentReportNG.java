package Demo.ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class  ExtentReportNG {
	ExtentSparkReporter reporter;
	ExtentReports extent;
	
	public ExtentReports reportGenerator() {			
		String path = System.getProperty("user.dir") + "//Reports//ExtentReport.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Cases Report");
		reporter.config().setReportName("Demo Project Reports");
		reporter.config().setTimeStampFormat("dd-MMM-yyyy hh:mm:ss a");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tested By:", "Dikshit");
		
		return extent;
	}
}
