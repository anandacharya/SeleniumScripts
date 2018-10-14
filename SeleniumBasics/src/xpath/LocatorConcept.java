/**
 * 
 */
package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author anand acharya
 * How to use different locators like Xpath, ID, Name, CssSelector, ClassName, LinkText, PartialLinkText in selenium
 */
public class LocatorConcept {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//invoke chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//manage drivers
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//open url
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
				
		//1. id -- (priority 1)
		driver.findElement(By.id("firstname")).sendKeys("testfirst");
		
		//2. name -- (priority 3)
		driver.findElement(By.name("lastname")).sendKeys("testlast");
		
		//3. xpath -- (priority 2)
		//absolute xpath should not be used -- html/body/div[1]/div[5]/a
		//only relative xpath should be used as below:
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("locator_test@gmail.com");
		driver.findElement(By.xpath("//*[@id='PASSWORD']")).sendKeys("12345abc");
		
		//4. linkText -- this is only for links
		driver.findElement(By.linkText("User Agreement")).click();
		
		//5. partialLinkText -- this is not useful
		driver.findElement(By.partialLinkText("User Privacy")).click();
		
		//6 class name -- not useful (priority 4)
		driver.findElement(By.className("checkbox__control")).click();
		
		//7. CSS Selector (priority 2)
		//if id is there -- #{id}
		//if class is there -- .{class}
		driver.findElement(By.cssSelector("#ppaFormSbtBtn")).click();
		
	}

}
