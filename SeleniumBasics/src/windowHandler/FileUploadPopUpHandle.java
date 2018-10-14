/**
 * 
 */
package windowHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author anand acharya
 * handle Browse button Window PopUp.
 */
public class FileUploadPopUpHandle {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch chrome
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://jpg2pdf.com/");
		
		Thread.sleep(10000);
		
		//upload file from local machine using the browse option
		driver.findElement(By.id("pick-files")).sendKeys("C:/Users/anand acharya/Desktop/ISTQB.JPG");

	}

}
