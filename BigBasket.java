package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BigBasket {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click on Change Location Select Chennai and click Continue
		driver.findElementByXPath("//div[@class='dropdown new-to-bb xhrcalls-only']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@class='form-group area-autocomplete city-select']").click();
		driver.findElementByXPath("//input[@type='search']").sendKeys("chennai",Keys.ENTER);
		driver.findElementByXPath("//div[@class='skp-exp']").click();
		//mouse over on  Shop by Category 	
		WebElement mouse = driver.findElementByXPath("//li[@class='dropdown full-wid hvr-drop']");
		Actions builder = new Actions(driver);
		builder.moveToElement(mouse).build().perform();	
		//Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS 	
		WebElement grains = driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
		builder.moveToElement(grains).build().perform();
		WebElement rice = driver.findElementByLinkText("Rice & Rice Products");
		builder.moveToElement(rice).build().perform();

		//click boilded rice
		driver.findElementByLinkText("Boiled & Steam Rice").click();
		 //clcik bb Royal
		Thread.sleep(3000);
		WebElement royal = driver.findElementByXPath("(//span[@class='cr'])[3]");
		builder.click(royal).build().perform();
		 
		  //Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown
		Thread.sleep(1000);
		  
		  //click ponni boiled rice
		  WebElement ponniRice = driver.findElementByXPath("//a[text()='Ponni Boiled Rice - Super Premium']/following::div[@class='btn-group btn-input clearfix ng-scope']");
		  builder.click(ponniRice).perform();
		  
		  Thread.sleep(1000);
		  //click 5kg
		  WebElement fiveKg = driver.findElementByXPath("(//ul[@class='dropdown-menu drop-select']//a)[9]");
		  builder.click(fiveKg).perform();
		  // print the price of Rice
		  String ricePrice = driver.findElementByXPath("(//div[@qa='price']//span[@class='discnt-price']/span)[3]").getText();
		  System.out.println(ricePrice);
		//Click Add button
		  driver.findElementByXPath("(//button[@class='btn btn-add col-xs-9'])[3]").click();
		 // Verify the success message displayed  
		  Thread.sleep(3000);
		  String text = driver.findElementByXPath("//div[@class='toast-title']").getText();
		  System.out.println(text);
		  //Type Dal in Search field and enter
		  driver.findElementByXPath("input").sendKeys("Dal",Keys.ENTER);
	//Go to Toor/Arhar Dal and select 2kg & set Qty 2 
		  
	
	
	}

}
