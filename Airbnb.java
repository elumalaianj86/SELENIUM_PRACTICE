package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Airbnb {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.airbnb.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Type Goa in location and select Goa Beach Baga
	driver.findElementById("bigsearch-query-detached-query").sendKeys("goa");
	Thread.sleep(3000);
	driver.findElementById("bigsearch-query-detached-query").sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
	// Select 2 Adults, one kid in Guest field and  click search
	driver.findElementByXPath("//div[text()='Add guests']").click();
	WebElement guestAdult = driver.findElementByXPath("(//span[@class='_8ovatg'])[2]");
	Actions builder = new Actions(driver);
	builder.doubleClick(guestAdult).build().perform();
	WebElement guestChild = driver.findElementByXPath("(//span[@class='_8ovatg'])[4]");
	builder.click(guestChild).build().perform();
	driver.findElementByClassName("_m9v25n").click();
	// Select Hotel Room as type of place
	Thread.sleep(3000);
	driver.findElementById("menuItemButton-room_type").click();
	WebElement hotelType = driver.findElementByXPath("(//span[@class='_167krry'])[3]");
	builder.click(hotelType).build().perform();
	driver.findElementById("filter-panel-save-button").click();
	//select Price as minimum 1000 , maximum as 10000
	driver.findElementById("menuItemButton-price_range").click();
	WebElement minprice = driver.findElementById("price_filter_min");
	Thread.sleep(3000);
	minprice.click();
	minprice.sendKeys(Keys.BACK_SPACE,"1000");
	WebElement maxprice = driver.findElementById("price_filter_max");
	maxprice.sendKeys(Keys.CONTROL,"10000");
	driver.findElementById("filter-panel-save-button").click();
	//Click More filters add bed as 2, bedroom as one and click show stays
	driver.findElementById("menuItemButton-dynamicMoreFilters").click();
	WebElement morefilter = driver.findElementByXPath("(//span[@class='_8ovatg'])[2]");
	builder.doubleClick(morefilter).build().perform();
	WebElement bedroom = driver.findElementByXPath("(//span[@class='_8ovatg'])[4]");
	builder.click(bedroom).build().perform();
	driver.findElementByXPath("//button[text()='Show 74 stays']").click();
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
