package windowHandler;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*3 types of pop-ups:

1) alerts – JavaScript Pop Up – Alert API (accept, dismiss)
2) File Upload pop up – Browse button (type = file, sendkeys(path)
3) Browser window pop up – Advertisement pop up (windowHandler API – getWindowHandles())*/

public class HandleWindowPopup {

	public static void main(String[] args) {
		//invoke chrome browser
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//manage windows
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//open url
		driver.get("http://www.popuptest.com/goodpopups.html");
		
		//click the first pop up
		driver.findElement(By.xpath("//a[text()='Good PopUp #1']")).click();
		
		//get unique id of the 2 windows using window handles
		Set<String> handler = driver.getWindowHandles();
		
		//Use Iterator method to get values from Set objects
		Iterator<String> it = handler.iterator();
		
		//shift the pointer from top of object to next value
		String parentWindow = it.next();
		System.out.println("parent window value is: "+parentWindow);
		
		//Shift the pointer to the next value of the object
		String childWindow = it.next();
		System.out.println("child window value is: "+childWindow );
		
		//switch to the popup window
		driver.switchTo().window(childWindow);
		
		//display title of child window
		System.out.println("title of pop up window is: "+driver.getTitle());
		
		//close the pop up window
		driver.close();
		
		//switch the parent window
		driver.switchTo().window(parentWindow);
		
		//display title of parent window
		System.out.println("title of child window is: "+driver.getTitle());

	}
}
