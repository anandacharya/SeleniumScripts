package handleCalendar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelectTest {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("ananda");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123456");
		WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();", element);
				
		Thread.sleep(3000);
		
		driver.switchTo().frame("mainpanel");
		
		String date = "32-May-2016";
		String dateArr[] = date.split("-"); // {2,May,2016}
		
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select monthSel = new Select(driver.findElement(By.name("slctMonth")));
		monthSel.selectByVisibleText(month);
		
		Select yearSel = new Select(driver.findElement(By.name("slctYear")));
		yearSel.selectByVisibleText(year);
		
		//.//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1]
		//.//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//.//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//.//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[3]/td[1]
		
		String beforeXpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXpath = "]/td[";
		
		final int totalWeekDays = 7;
		boolean flag = false;
		String dayVal = null;
		
		for(int rowNum=2; rowNum<=7; rowNum++){
			for(int colNum=1; colNum<=totalWeekDays; colNum++){
				try{
				dayVal = driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).getText();
				}
				catch(Exception e){
					System.out.println("Enter correct date value");
					flag = false;
					break;
				}
				System.out.println(dayVal);
				if(dayVal.equals(day)){
					driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum+"]")).click();
					flag = true;
					break;
				}
			}
			if(flag){
				break;
			}
		}
	}

}
