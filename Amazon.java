package workout90Days;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class Amazon {

	public static void main(String[] args) throws Exception {
		
	ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Type "oneplus 7 pro mobiles" in Search Box and Enter
		driver.findElementById("twotabsearchtextbox").sendKeys("oneplus 7 pro mobiles",Keys.ENTER);
//Print the price of the first resulting mobile		
		List<WebElement> search = driver.findElementsByXPath("//span[@data-a-color='price']");
		String first = search.get(0).getText().replaceAll("?", "");
		System.out.println(first);
//Click on the Mobile (First resulting) image
	List<WebElement> img= driver.findElementsByXPath("//div[@class='a-section aok-relative s-image-fixed-height']");
		WebElement firstImage = img.get(0);
		firstImage.click();
//Switch to the new window		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handle = new ArrayList<String>(windowHandles);
		String popWindow = handle.get(1);
		driver.switchTo().window(popWindow);
		String rating = driver.findElementByXPath("//span[@data-action='acrLink-click-metrics']//span").getText();
		System.out.println(rating);
//Click 'Add to Cart'
		driver.findElementByXPath("//span[@id='submit.add-to-cart']").click();
// Confirm "Added to Cart" text message appeared
		String cart=driver.findElementByXPath("//div[@id='huc-v2-order-row-confirm-text']/h1").getText();
		System.out.println(cart);
		if(cart.equalsIgnoreCase("Added to Cart")) {
			System.out.println("confired product Add");
		}
		else {
			System.out.println("product	not Add");
		}
//Click on Proceed to checkout
		driver.findElementByXPath("//span[@id='hlb-ptc-btn']").click();
// Confirm the title is "Amazon Sign In"
		String title= driver.getTitle();
		System.out.println(title);
		if (title.equalsIgnoreCase("Amazon Sign In")) {
			System.out.println("Confirmed Both titles are Same");
		} else {
			System.out.println("Confirmed Both titles are not	Same");
		}
// Click Continue (without entering mobile number / email)
		driver.findElementByXPath("//span[@id='continue']").click();
//Verify the error message: Enter your email or mobile phone number
		String error=driver.findElementByXPath("//div[@role='alert']").getText();
		System.out.println(error);
		if (error.equalsIgnoreCase(" Enter your email or mobile phone number")) {
			System.out.println("verified Both error messages are same");
		} else {
			System.out.println("verified Both error messages are notsame");
		}
		
//Close both browsers
		driver.quit();
		

				
	}

}
