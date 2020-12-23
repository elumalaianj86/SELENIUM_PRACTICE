package workout90Days;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pepperfry {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.pepperfry.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Mouseover on Furniture and click Office Chairs under Chairs	
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@id='regPopUp']/a"))).click();
/*		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='close']"))).click();
		driver.switchTo().defaultContent();*/
		WebElement Furniture = driver.findElementByXPath("//a[@rel='meta-furniture']");
		Actions builder = new Actions(driver);
		builder.moveToElement(Furniture).build().perform();
		driver.findElementByXPath("//a[text()='Office Chairs']").click();
//click Executive Chairs		
		driver.findElementByXPath("//img[@alt='Executive Chairs']");
//Change the minimum Height as 50 in under Dimensions		
	driver.findElementByXPath("//ul[@class='clip__filter-dimension']//input").clear();
	driver.findElementByXPath("//ul[@class='clip__filter-dimension']//input").sendKeys("50",Keys.ENTER);
//Add "Buff High Back Executive Chair In Black Colour" chair to Wishlist
		Thread.sleep(3000);
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
 WebElement chair= driver.findElementByXPath("//img[@alt='Buff High Back Executive Chair in Black Colour']/following::a");
		builder.click(chair).build().perform();
//Mouseover on Bedroom and Click Study tables
		WebElement bedRoom = driver.findElementByXPath("//a[@rel='meta-bedroom']");
		builder.moveToElement(bedRoom).build().perform();
		driver.findElementByXPath("(//a[text()='Study Tables'])[3]").click();
//Select Spacewood as Brand
		driver.findElementByXPath("//li[@data-search='Spacewood']").click();
// Select Price as 7000 to 8000
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='clip__filter-warpper']/following::label)[3]").click();
//Add "Winner Hutch Table In Rigato Walnut Finish" to Wishlist		
		driver.findElementByXPath("//a[@data-productname='Winner Hutch Table in Rigato Walnut Finish']").click();
// Verify the number of items in Wishlist
		
		
		
		/*
		
		11) Navigate to Wishlist
		12) Move Table only to Cart from Wishlist
		13) Click Proceed to Pay Securely
		14) Enter Pincode as 600028 in Delivery & Assembly Details and click Go
		14) Click Place Order
		15) Capture a screenshot by Clicking on Order Summary
		16) Close the browser		
		
		
		*/
		
		
		
		
		
		
		
		

	}

}
