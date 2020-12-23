package workout90Days;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Mouse over on WOMEN
		WebElement womens = driver.findElementByXPath("(//div[@class='desktop-navLink'])[2]");
		Actions builder = new Actions(driver);
		builder.moveToElement(womens).build().perform();
		// Click Jackets & Coats
		driver.findElementByLinkText("Jackets & Coats").click();
		// Find the total count of item (top)
		String totalCount = driver.findElementByXPath("//span[@class='title-count']").getText();
		//System.out.println(totalCount);
		String replace = totalCount.replaceAll("-","").replaceAll(" ", "").replaceAll("items", "");
		//System.out.println(replace);
		//  convert string to integer
		int count = Integer.parseInt(replace);    
		//Validate the sum of categories count matches
		String jackets = driver.findElementByXPath("(//span[@class='categories-num'])[1]").getText().replace("(", "").replace(")", "");
		int jacketsCount = Integer.parseInt(jackets);
		String coats = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText().replace("(", "").replace(")", "");
		int coatsCount = Integer.parseInt(coats);
		// System.out.println(coatsCount);
		if (count==(jacketsCount+coatsCount)) {
			System.out.println("Both counts are equal");
		}
		else {
			System.out.println("Both counts not are equal");
		}
		// Check Coats
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();
		// Click + More option under BRAND	
		driver.findElementByXPath("//div[@class='brand-more']").click();
		//	 Type MANGO and click checkbox
		WebElement type = driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']");
		builder.sendKeys(type, "MANGO").build().perform();
		WebElement checkBox = driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[5]");
		builder.click(checkBox).build().perform();
		//  Close the pop-up 
		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();
		//Confirm all the Coats are of brand MANGO
		List<WebElement> brand = driver.findElementsByXPath("//h3[text()='MANGO']");
		for (WebElement eachBrand : brand) {
			String brandText = driver.findElementByXPath("//h3[text()='MANGO']").getText();
			if(brandText.contains("MANGO")) {
				System.out.println("All Brand are MANGO");
			}
			else {
				System.out.println("All Brand are not MANGO");
			}
		}
		//Sort by Better Discount
		WebElement sort = driver.findElementByXPath("//span[text()='Recommended']");
		builder.moveToElement(sort).build().perform();
		driver.findElementByXPath("(//label[@class='sort-label '])[3]").click();
		//Find the price of first displayed item
		List<WebElement> price = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
		WebElement firstPrice = price.get(0);
		String text = firstPrice.getText();
		System.out.println(text);
		// Mouse over on size of the first item
		builder.moveToElement(firstPrice).build().perform();
		//Click on WishList Now
		driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist ']").click();
		//Close Browser
		driver.close();

	}

}


