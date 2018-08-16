/**
 * 
 */
package captureScreenshot;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author anand acharya
 * Selenium code to capture screenshot on faiure using ITestResut interface
 */
public class FacebookFailureSnapshot {
	WebDriver driver;
	
	@Test
	public void captureFailureScreenshot() throws InterruptedException{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotification.enabled", false);
		driver = new FirefoxDriver(ffprofile);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		
		//if the elemnt id is incorrect then capture snapshot of the screen
		driver.findElement(By.id("emailiswrong")).sendKeys("screenshotdemo");
	}
	
	@AfterMethod //this will execute after every test
	//ITestResult is an interface that keeps all information about the test case we executed like:
	//test case status and test name
	public void tearDown(ITestResult result){
		if(ITestResult.FAILURE==result.getStatus()){
			ScreenshotUtility.captureScreenshots(driver, result.getName());
		}
		driver.quit();
	}
}
