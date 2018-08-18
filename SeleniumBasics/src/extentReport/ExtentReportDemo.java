/**
 * 
 */
package extentReport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import captureScreenshot.ScreenshotUtility;

/**
 * @author anand acharya
 * Sample selenium scripts for generating reports using extent report API
 * Add the extent Report jar file
 */
public class ExtentReportDemo {

	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeMethod()
	public void setup(){
		//start reporters
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./Reports/amazon_login.html");
				
		//create ExtentReports and attach reporter
		extent = new ExtentReports();
		extent.attachReporter(reporter);
				
		//creates a toggle for the given test, adds all log events under it
		logger = extent.createTest("LoginTest");
	}
	
	@Test
	public void loginTest() throws IOException, InterruptedException{
		//the classes ExtentHtmlReporter, ExtentReports, ExtentTest are used for Extent report 
		System.out.println("Login to Amazon");
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotification.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		logger.log(Status.INFO, "Login to Amazon");
		driver.get("https://www.amazon.com.au/");
		
		Thread.sleep(5000);
		logger.log(Status.PASS, "Login Successful");
		
		//calling flush writes everyting in the log file
		extent.flush();
		
		//Verify title
		Assert.assertTrue(driver.getTitle().contains("AnandAcharya"));
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		if(result.getStatus()==ITestResult.FAILURE){
			//Call the utlity class to capture failure screenshot
			String temp = ScreenshotUtility.captureScreenshotsRunTime(driver);
			//add screen snapshot at the result	
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		}
		
	extent.flush();
	driver.quit();
	}
			
}