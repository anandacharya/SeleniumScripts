/**
 * 
 */
package captureScreenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * @author anand acharya
 * static method to capture screenshot
 */
public class ScreenshotUtility {
	
	public static void captureScreenshots(WebDriver driver, String screenshotName){
		try {
			//TakesScreenshot is a predefined interface in Seelnium Webdriver. 
			//we cannot create object of an interface. So typecast the driver to takescreeshot
			TakesScreenshot ts = (TakesScreenshot)driver;	
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshots/"+screenshotName+".png"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
	}
	
	public static String captureScreenshotsRunTime(WebDriver driver){
		
			//TakesScreenshot is a predefined interface in Seelnium Webdriver. 
			//we cannot create object of an interface. So typecast the driver to takescreeshot
			TakesScreenshot ts = (TakesScreenshot)driver;	
			File src = ts.getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".jpg";
			File destination = new File(path);
			
		try {
			FileUtils.copyFile(src, destination);
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}
		
		return path;
	}
}
