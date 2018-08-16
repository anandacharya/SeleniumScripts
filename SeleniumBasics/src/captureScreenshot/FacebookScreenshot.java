/**
 * 
 */
package captureScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

/**
 * @author anand acharya
 * Selenium scripts to capture screenshot
 */
public class FacebookScreenshot {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws Exception 
	 */
	@Test
	public void captureScreenshot() throws IOException, Exception {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotification.enabled", false);
		WebDriver driver = new FirefoxDriver(ffprofile);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.facebook.com/");
		Thread.sleep(5000);
		
		//Capture screenshot of homepage
		ScreenshotUtility.captureScreenshots(driver, "Browser started");
		
		//Capture screenshot of login name
		driver.findElement(By.id("email")).sendKeys("screenshotdemo");
		ScreenshotUtility.captureScreenshots(driver, "TypeUName");
		
		driver.quit();
	}

}
