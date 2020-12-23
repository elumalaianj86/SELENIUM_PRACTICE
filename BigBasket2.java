package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class BigBasket2 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//location		
		driver.findElementByXPath("//input[@value='Change Location']").click();
		WebElement location = driver.findElementByXPath("//div[@ng-model='vm.selectedlocation.cityquery']");
		Actions builder = new Actions(driver);
		//location.click();
		builder.sendKeys(location, "Chennai",Keys.TAB).build().perform();
		driver.findElementByXPath("//button[@qa='continueBtn']").click();
//mouse over on  Shop by Category 
		WebElement shop = driver.findElementByXPath("//a[@qa='categoryDD']");
		builder.moveToElement(shop).build().perform();
//Go to FOODGRAINS, OIL & MASALA --> RICE & RICE PRODUCTS		
		WebElement food = driver.findElementByXPath("(//a[text()='Foodgrains, Oil & Masala'])[2]");
		builder.moveToElement(food).build().perform();
//Select Boiled & Steam Rice		
		WebElement rice = driver.findElementByXPath("(//a[text()='Rice & Rice Products'])[2]");
		builder.moveToElement(rice).build().perform();
		driver.findElementByXPath("(//a[text()='Boiled & Steam Rice'])[2]").click();
//Select the Brand as bb Royal		
		builder.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//span[text()='bb Royal']").click();
// Go to Ponni Boiled Rice - Super Premium and select 5kg bag from Dropdown	
		Thread.sleep(3000);
		driver.findElementByXPath("//div[@qa='product_name']/a[@uib-tooltip='Ponni Boiled Rice - Super Premium']").click();
		driver.findElementByXPath("(//div[@id='title']/following::section[2]//div)[3]").click();
//print the price of Rice
		String price = driver.findElementByXPath("//h1[@style='-webkit-line-clamp:initial']/following::td[@data-qa='productPrice']").getText().replaceAll("Rs", "").replace(" ","");
		System.out.println(price);
//Click Add button		
		driver.findElementByXPath("//div[@data-qa='addToBasket']").click();
// Verify the success message displayed		
		String popUp = driver.findElementByXPath("//div[text()='Successfully added Ponni Boiled Rice - Super Premium to the basket']").getText();
		System.out.println(popUp);
		if (popUp.equalsIgnoreCase("Successfully added Ponni Boiled Rice - Super Premium to the basket")) {
			System.out.println("Successfully Rice Add");
		} else {
			System.out.println("Rice is not Add");
		}
//Type Dal in Search field and enter
		driver.findElementByXPath("//input[@aria-label='productSearch']").sendKeys("Dal",Keys.ENTER);
// Go to Toor/Arhar Dal and select 2kg & set Qty 2		
		driver.findElementByXPath("//div[@qa='product_name']/a[text()='Toor Dal/Arhar Dal - Desi']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//section[@class='irDHq']//div[@class='_2Z6Vt    rippleEffect'][3]").click();
// Click Add button		
		driver.findElementByXPath("//div[@data-qa='addToBasket']").click();
		driver.findElementByXPath("//div[@data-qa='add']").click();
//Mouse hover on My Basket		
		WebElement basket = driver.findElementByXPath("//div[@data-qa='myBasket']");
		builder.moveToElement(basket).build().perform();
// Validate the Sub Total displayed for the selected items		
		
		
		
		
		/*
		
		
		3) 
		4)
		5) 
		6)
		7) 
		8) 
		9) 
		10) 
		12) 
		13) 
		14)
		15)  
		16)
		17) Reduce the Quantity of Dal as 1 
		18) Validate the Sub Total for the current items
		19) Close the Browser*/
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
