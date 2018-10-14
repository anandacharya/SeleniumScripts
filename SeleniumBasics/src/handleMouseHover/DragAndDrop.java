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
 * drag and drop element from one place to other using Actions class
 */
public class DragAndDrop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//invoke and launch chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
				
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0); //switch to frame if it is present
		
		//create actions class for move movement
		Actions action = new Actions(driver);
		
		//drag and drop element
		action.clickAndHold(driver.findElement(By.id("draggable")))
		.moveToElement(driver.findElement(By.id("droppable")))
		.release()
		.build()
		.perform();
		
	}

}
