/**
 * 
 */
package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author anand acharya
 * 
 */
public class ImplicitWait {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//invoke and launch chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome
		driver.get("https://www.ebay.com/"); //enter url
		
		driver.manage().window().maximize(); //maximise window
		driver.manage().deleteAllCookies(); //deleting cookies
		
		//dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //give max time of 30 secs to load the page
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //give max time of 15 secs for all  elments to be visble on the page
	}

}
