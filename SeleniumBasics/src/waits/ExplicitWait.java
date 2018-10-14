/**
 * 
 */
package waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author anand acharya
 * how to wait till a specific element is visible
 */
public class ExplicitWait {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome
		driver.get("https://www.facebook.com/"); //enter url
		
		driver.manage().window().maximize(); //maximise window
		driver.manage().deleteAllCookies(); //deleting cookies
		
		//dynamic waits
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		onClick(driver, driver.findElement(By.xpath("//input[@value='Log In']")), 10);//login button
		
		Thread.sleep(3000);
		driver.navigate().back();
		
		onClick(driver, driver.findElement(By.xpath("//a[contains(text(),'Forgotten account?')]")), 10);//forgot password link
		
	}
	
	//create a method for the element to be clicked if visible
	public static void onClick(WebDriver driver, WebElement locator, int timeout){
		new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
	}

}
