/**
 * 
 */
package textbox_dropdownbox;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

/**
 * @author anand acharya
 * Selenium scripts to enter values in text box and select dropdown boxes
 */
public class SelectEnterValues {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {

		//Set Firefox driver
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		FirefoxProfile ffprofile = new FirefoxProfile();
		ffprofile.setPreference("dom.webnotifications.enabled", false);
		WebDriver driver = new FirefoxDriver(ffprofile);
		
		//manage browser
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//open url for creating account in the portal
		driver.get("https://secure.yatra.com/social/common/yatra/register?_ga=2.253369933.519131547.1533972711-1244605295.1533972711");
		Thread.sleep(5000);
		
		//Find email id textbox element and enter value
		driver.findElement(By.id("login-input")).sendKeys("thtrasdgmail.com");
		//clear the value
		driver.findElement(By.id("login-input")).clear();
		//Enter value again
		driver.findElement(By.id("login-input")).sendKeys("thtrasd@gmail.com");
		
		//wait for 10 seconds
		Thread.sleep(10000);
		
		// will print in the console true or false
		System.out.println(driver.findElement(By.id("login-continue-btn")).isDisplayed());
		
		//click button to proceed to next page
		driver.findElement(By.id("login-continue-btn")).click();
		
		//Validations to check if page is loaded or not
		if(driver.findElement(By.xpath(".//*[@id='mobile-number-block']/p[1]")).getText().equalsIgnoreCase("Mobile Number")){
			System.out.println("page is loaded");
		}
		else {System.out.println("page is not loaded");
		}
		
						
		//Select the required dropdown country code
		Select countrycode = new Select(driver.findElement(By.id("isd-selector")));
		countrycode.selectByVisibleText("Australia (+61)");
		//countrycode.selectByIndex(13);
		//countrycode.selectByValue("61");
		
		//Select the required title from dropdown
		Select title = new Select(driver.findElement(By.id("signup-user-designation")));
		title.selectByVisibleText("Mr.");
		
		//Select check box
		driver.findElement(By.xpath(".//*[@id='whatsAppNotif']/../label/span")).click();
		
		//extract value from input box
		System.out.println(driver.findElement(By.id("signup-email-id")).getAttribute("value"));
		
		//Click the create button
		driver.findElement(By.id("signup-form-continue-btn")).click();
		
	}

}
