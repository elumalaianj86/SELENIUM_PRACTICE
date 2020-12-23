package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class JustDail {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.justdial.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//set location as chennai
		driver.findElementById("city").clear();
		driver.findElementById("city").sendKeys("Chennai");
		Thread.sleep(3000);
		driver.findElementById("city").sendKeys(Keys.ENTER);
		//click Auto care 
		driver.findElementById("hotkeys_text_7").click();
		//click carRepair
		driver.findElementByXPath("//span[text()='Car Repair']").click();
		//click hyundai button
		driver.findElementByXPath("//span[text()='Hyundai']").click();
		// click Hyundai Xcent
		driver.findElementByXPath("//span[text()='Hyundai Xcent']").click();
		Thread.sleep(3000);
		//click location
		driver.findElementByLinkText("Location").click();
		//enter porur and click
		driver.findElementById("sortbydist").sendKeys("porur",Keys.TAB);
		
		
		
		
		
		
	}

}
