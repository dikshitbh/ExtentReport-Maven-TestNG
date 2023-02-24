package Demo.ExtentReport;

import org.openqa.selenium.By;
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
		driver = WebDriverManager.edgedriver().create();
		driver.manage().window().maximize();

	}

	@Test
	public void openWebPageTest() {
		driver.get("https://www.bing.com");
		driver.getCurrentUrl();
		String title = driver.getTitle();
		System.out.println(title);

	}

	@Test
	public void validatePageTitleTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "https://www.google.com/");
		
	}
	
	@Test
	public void enterInputInSearchFieldTest() {
		driver.findElement(By.name("y")).sendKeys("Hello World!");
	}

	@AfterTest
	public void closeSession() {
		driver.quit();

	}

}
