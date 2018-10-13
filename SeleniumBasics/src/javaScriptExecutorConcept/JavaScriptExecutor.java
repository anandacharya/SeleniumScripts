/**
 * 
 */
package javaScriptExecutorConcept;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author anand acharya
 Do something amazing and cool stuff with JavaScriptExecutor With Selenium WebDriver:

1. Highlight an Element
2. DrawBorder around an Element
3. Generate custom Alert during Test Execution
4. Click on an Element by using JaveScript
5. Refresh browser by using JavaScript
6. Get Title by using JavaScript
7. Get InnerText of page by using JavaScript
8. Scroll Into View and Scroll Page Down
 */
public class JavaScriptExecutor {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		//launch chrome
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//enter url
		driver.get("https://www.freecrm.com");
		
		//enter username and password
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ananda123");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		
		flash(loginBtn, driver); //highlight the button
		
		drawBorder(loginBtn, driver);//draw a border
		//take screenshot and store as a file format
		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//now copy the file to desired location using copyfile method
		FileUtils.copyFile(scr, new File(System.getProperty("user.dir")+"/element.png"));
		
		//generate alert
		generateAlert(driver, "there is issue on login button on Login Page");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//to refresh page by Selenium
		//driver.navigate().refresh();
		
		//refresh page by using javascript executor
		refreshBrowserByJS(driver);
		
		//click on any element by using Javascript Executor
		clickElementByJS(loginBtn, driver);
				
		//get title by javascript executor
		System.out.println(getTitleByJS(driver));
		
		//get the page text by JS
		System.out.println(getPageInnerText(driver));
		
		//scroll down vertically to the bottom by JS
		//scrollPageDown(driver);
		
		//scroll down till particular element is visible by JS
		WebElement forgotPswd = driver.findElement(By.xpath("//a[contains(text(), 'Forgot Password?')]"));
		scrollIntoView(forgotPswd, driver);
		
		Thread.sleep(3000);
		forgotPswd.click();
	}
	
	public static void flash(WebElement element, WebDriver driver){
		//javascriptExecutor is a class and we have to cast our driver into javascriptExecutor
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i = 0; i<50; i++){
			changeColor("rgb(0,200,0)", element, driver); //1
			changeColor(bgcolor,element,driver); //2
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		//executeScript -- to execute JavaScript code
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
		try{
			Thread.sleep(20);
		} catch (InterruptedException e){
		}
	}
	
	public static void drawBorder(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(WebDriver driver, String message){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void refreshBrowserByJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static void clickElementByJS(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static String getTitleByJS(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title").toString();
		return title;
	}
	
	public static String getPageInnerText(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}
	
	public static void scrollPageDown(WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver){
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}

