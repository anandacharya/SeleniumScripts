package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class chooseBrowser {

	public static void main(String[] args) {
		
		/*//Set Chrome Browser
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromerdriver.exe");
		WebDriver driver = new ChromeDriver();*/
		
		/*//Set Microsoft Edge browser
		System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"/drivers/MicrosoftWebDriver.exe");
		WebDriver driver = new EdgeDriver();*/
		
		/*//Set IE browser
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();*/
		
		//Set Firefox driver
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		
		//maximize windows
		driver.manage().window().maximize();
		
		//open url
		driver.get("https://google.com.au");
		driver.navigate().to("https://facebook.com");
		
		//close browser
		driver.quit();
		driver.close();
	}

}
