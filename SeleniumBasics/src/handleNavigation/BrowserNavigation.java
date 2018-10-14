/**
 * 
 */
package handleNavigation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author anand acharya
 * handle Back, Forward and Refresh in browser
 */
public class BrowserNavigation {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome
		driver.get("https://www.google.com/"); //enter url
		
		driver.manage().window().maximize(); //maximise window
		driver.manage().deleteAllCookies(); //deleting cookies
		
		//dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//external navigation
		driver.navigate().to("https://www.amazon.com.au/");
		
		//back and forward button simulations
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		driver.navigate().forward();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		driver.navigate().refresh(); //refresh the page
	}

}
