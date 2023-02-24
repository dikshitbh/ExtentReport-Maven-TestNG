package Demo.ExtentReport;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;
	ExtentSparkReporter reporter;
	ExtentReports extent;

	@BeforeTest
	public void preConfig() {
		String path = System.getProperty("user.dir") + "//Reports//ExtentReport.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Test Cases Report");
		reporter.config().setReportName("Demo Project Reports");
		reporter.config().setTimeStampFormat("dd-MMM-yyyy hh:mm:ss a");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tested By:", "Dikshit");

	}

	@Test
	public void invokeBrowser() {
		extent.createTest("Invoking the browser");
		driver = WebDriverManager.edgedriver().create();
		driver.manage().window().maximize();

	}

	@Test
	public void openWebPage() {
		ExtentTest test =  extent.createTest("Opening Web Application");
		driver.get("https://www.google.com");
		driver.getCurrentUrl();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Hello World!");
		test.fail("Test is failed");
		driver.quit();
		extent.flush();
		
	}

//	@AfterTest
//	public void closeSession() {
//		driver.quit();
//		extent.flush();
//	}

}
