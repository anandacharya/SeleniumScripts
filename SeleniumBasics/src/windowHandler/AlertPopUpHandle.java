/**
 * 
 */
package windowHandler;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author anand acharya
 * How to handle JavaScript Alerts
 */
public class AlertPopUpHandle {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//click the Go button without entering username and passeword
		driver.findElement(By.name("proceed")).click();
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
			
		String text = alert.getText();
		
		if(text.equals("Please enter a valid user name")){
			System.out.println("Alert message is correct");
		}
			else {
				System.out.println("Alert message is incorrect");
			}
		
		alert.accept(); //to click ok
		//alert.dismiss(); //to click cancel
		
		Thread.sleep(5000);
		driver.close();
	}

}
