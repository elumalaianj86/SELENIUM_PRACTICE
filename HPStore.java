package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HPStore {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://store.hp.com/in-en/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Mouse over on Laptops menu and click on Pavilion		
		WebElement laptop = driver.findElementByXPath("//span[text()='Laptops']");
		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.moveToElement(laptop).build().perform();
		driver.findElementByXPath("//span[text()='Pavilion']").click();
//Under SHOPPING OPTIONS -->Processor -->Select Intel Core i7		
		driver.findElementByXPath("//div[@data-title='Processor']//li").click();
// Hard Drive Capacity -->More than 1TB		
		driver.findElementByXPath("//div[@data-title='Hard Drive Capacity']//li[2]").click();
//Select Memory Standard as 8GB		
		driver.findElementByXPath("//div[@data-title='Memory standard']//li").click();
//Print the First resulting Product Name and Price		
		String firstProduct = driver.findElementByXPath("//div[@data-container='product-grid']").getText();
		System.out.println(firstProduct);
		String price = driver.findElementByXPath("//span[@data-price-type='finalPrice']/span").getText();
		System.out.println(price);
//Click on Add to Cart		
		driver.findElementByXPath("//button[@title='Add To Cart']").click();
//Click on Shopping Cart icon --> Click on View and Edit Cart		
		driver.findElementByXPath("//div[@data-block='minicart']").click();
		driver.findElementByXPath("//a[@class='action primary viewcart']").click();
//Check the Shipping Option --> Check availability at Pincode		
		driver.findElementByXPath("//input[@name='pincode']").sendKeys("600081");
		driver.findElementByXPath("//button[text()='check']").click();
//Verify the order Total against the product price
		String order = driver.findElementByXPath("//td[@data-th='Order Total']//span").getText().replaceAll("₹", "");
		System.out.println(order);
		if (order.contains(price)) {
			System.out.println("Both Prices are equal");
		} else {
				System.out.println("Prices are not equal");
		}
//Proceed to Checkout if Order Total and Product Price matches		
		// driver.findElementByXPath("//button[@title='Proceed to Checkout']").click();
		
		/*
		
		2) 
	3) 
	4) 
	5) 
	6) 
	7) 
	8) 
	9) 
	10) 
	11) 
	12) Click on Proceed to Checkout and Click on Place Order
	13) Capture the Error message and Print
	14) Close Browser*/	
		
		
		
		
		
		
		
		
		
	}

}
