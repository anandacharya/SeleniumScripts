/**
 * 
 */
package handleMouseHover;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * @author anand acharya
 * mouse movement over a menu option to display sub menus without clicking
 */
public class MouseMovement {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		//invoke and launch chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		
		//use Actions class for mouse hover
		Actions action = new Actions(driver);
		
		//hover the mouse to the required element
		action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
		
		Thread.sleep(3000);
		
		//click on the submenu
		driver.findElement(By.xpath("//a[contains(text(),'Priority Check-in')]")).click();
		
		
	}

}
