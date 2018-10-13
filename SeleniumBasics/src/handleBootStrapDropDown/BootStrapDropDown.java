/**
 * 
 */
package handleBootStrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.el.EqualsOperator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author anand acharya
 *
 */
public class BootStrapDropDown {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//invoke chrome
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//manage windows
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//li//a//label"));
		
		System.out.println("total elements are: "+list.size());
		
/*		//select all checkboxes/options in the dropdown
		for (int i=0; i<list.size(); i++){
				System.out.println(list.get(i).getText());
				list.get(i).click();
			}*/
		
		//select a particular option in dropdown
		for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("Java")){
				list.get(i).click();
				break;
			}
		}
	}

}
