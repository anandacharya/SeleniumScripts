/**
 * 
 */
package action_assert;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author anand acharya
 * Program to navigate through a website using actions and assert statments
 */
public class Navigate {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//Set Firefox driver
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			
		//disable firefox notifications
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.notifications.enabled", "false");
		WebDriver driver = new FirefoxDriver(ffprofile);
		driver.manage().deleteAllCookies();
		
		//open website
		driver.manage().window().maximize();
		driver.get("http://www.cricbuzz.com/");
		
		//hardcoded wait
		Thread.sleep(5000);
		
		//verify if the required element is present or not
		WebElement web=driver.findElement(By.xpath(".//*[text()='Archives']"));
		boolean bool=web.isDisplayed();
		Assert.assertEquals(true, bool); //here it will match that if that element is present or not. If present it will continue execution from the next line or if it is not present the execution stops there and your test case fails.
				
		//go to archives page
		driver.findElement(By.xpath(".//*[text()='Archives']")).click();
		
		//Explict wait
		WebDriverWait waitexplict = new WebDriverWait(driver, 5); //wait for 5 sec
		waitexplict.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Cricket Match Archives']")));
		
		//Click 2017
		driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[4]/div[2]/div[2]/a[7]")).click();
		Thread.sleep(3000);
		
		//scroll down
		((JavascriptExecutor)driver).executeScript("scroll(0,400)");
		System.out.println("Scrolling completed");
		
		//click series
		driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[4]/div[1]/div[1]/div[7]/a/span")).click();
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//hover over venue dropdown
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='series-matches']/span/a"))).build().perform();
		Thread.sleep(3000);
		System.out.println("Mouse hovered over venues");
		
		//click 2nd venue
		act.click(driver.findElement(By.xpath(".//*[@id='series-matches']/span/nav/a[2]"))).build().perform();
		Thread.sleep(3000);
		
/*		//Other action codes
		act.doubleClick(driver.findElement(By.xpath(""))).build().perform();
		// to enter inputs in dialog box
		act.sendKeys("C:/");
		act.sendKeys(Keys.ENTER);
		// drag and drop
		act.dragAndDrop(driver.findElement(By.xpath("")), driver.findElement(By.xpath(""))).build().perform();*/
		
		System.out.println("test completed");
	}

}
