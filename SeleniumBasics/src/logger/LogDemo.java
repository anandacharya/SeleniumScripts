/**
 * 
 */
package logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author anand acharya
 * Import the log4j jar, and add the log4j properties file in the project home directory
 */
public class LogDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Logger logger = Logger.getLogger("LogDemo");
		
		PropertyConfigurator.configure("Log4j.properties");
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotification.enabled", false);
		
		WebDriver driver = new FirefoxDriver(ffprofile);
		logger.info("Firefox opened");
		
		driver.manage().deleteAllCookies();
		logger.info("cookies deleted");
		
		driver.manage().window().maximize();
		logger.info("Browser maximized");
	
		driver.get("https://www.cricbuzz.com/");
		logger.info("Website launched");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//*[@id='cb-main-menu']/a[2]")).click();
		logger.info("Clicked on the live score menu");
		
		System.out.println("Test Completed");
	}

}
