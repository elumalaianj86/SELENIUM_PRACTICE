package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flipkart {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Search for Home Theaters
		driver.findElementByXPath("//input[@title='Search for products, brands and more']").sendKeys("Home Theaters",Keys.ENTER);
//Choose customer ratings 4* and above		
		driver.findElementByXPath("//div[@title='4★ & above']").click();
//Confirm showing result count reduced after selection
		
		
	}

}
/*1. Launch firefox browser
2. Go to ""
3. 
4. 
5. 
6. Click price High to Low and confirm if it is Blue upon click
7. Confirm all the displayed products are sorted by price
8. Select any 2 products for compare 
9. Click compare and confirm both are displayed on compare screen*/