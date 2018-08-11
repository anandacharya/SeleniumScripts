package waits;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author anand acharya
 * Program to use different type of waits like hardcoded, Implict, Explicit, and Fluent
 */
public class UsingWaits {

	public static void main(String[] args) {
		//Set Firefox driver
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		//FirefoxProfile ffprofile = new FirefoxProfile();
		FirefoxProfile geoDisabled = new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", false);
		/*geoDisabled.setPreference("geo.provider.use_corelocation", false);
		geoDisabled.setPreference("geo.prompt.testing", false);
		geoDisabled.setPreference("geo.prompt.testing.allow", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);*/
		
		WebDriver driver = new FirefoxDriver(geoDisabled);
				
		//manage browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//open website
		driver.get("https://www.yatra.com/");
		
		//HardCoded Wait for 5 seconds
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Implicit Wait - Each Line after this implicit wait line will wait for the given timeout for the object to load
		//This is same for all the objects, hence u cannot put different waits for different objects
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//click a link on home page to open a new page
		driver.findElement(By.xpath(".//*[@id='themeSnipe']//ul[@class='justified-menu desktop-navs settings-content responsivetabshow']/li[5]/a")).click();
		
		//Explicit Wait - Here we put different waits for different objects and the code will wait on this line until the given ExpectedCondition is met
		WebDriverWait waitexplict = new WebDriverWait(driver, 10); //wait for 5 sec
		//waitexplict.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
		waitexplict.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()='Welcome to Yatra for Business']")));
		
		//click the signup button
		driver.findElement(By.xpath(".//*[text()='Sign up']")).click();
		
		//Fluent Wait - Similar to explicit wait only difference is the polling (frequency part)
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class);		
		try
		{
			
/*			WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
					{
					  public WebElement apply(WebDriver driver) {
					  return driver.findElement(By.xpath("//*[@class='yourname-group']/div[2]/input"));
					}
					});*/
			
			
			WebElement element =  driver.findElement(By.xpath("//*[@class='yourname-group']/div[2]/input"));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//*[@class='yourname-group']/div[2]/input")).sendKeys("Anand");
		
		System.out.println("test completed");
		

	}

}
