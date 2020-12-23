package workout90Days;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Nykaa  {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);		
		WebElement element = driver.findElementByXPath("//a[text()='brands']");
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click().perform();
		WebElement element2 = driver.findElementByXPath("//a[text()='Popular']");
		builder.moveToElement(element2).click().perform();
		driver.findElementByXPath("(//a[@target='_blank']/img)[5]").click();
		Set<String> handles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(handles);
		String handle1 = window.get(1);
		driver.switchTo().window(handle1);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("L'Oreal Paris")){
			System.out.println("lauched in corrert Page");
		}
		else {
			System.out.println("Lauched in Incorrect page");
		}
		driver.findElementByXPath("//span[text()='Sort By : ']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("//label[@for='chk_Shampoo_undefined']/span").click();
/*	//check whether the Filter is applied with Shampoo
		WebElement filter = driver.findElementByClassName("pull-left applied-filter-lists");
		System.out.println(filter.isDisplayed());*/
	
		driver.findElementByXPath("(//div[@class='row'])[10]").click();
		Set<String> popupWindow = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(popupWindow);
		String handle2 = window1.get(2);
		driver.switchTo().window(handle2);
		driver.findElementByXPath("//span[@class='size-pallets']").click();
		WebElement price = driver.findElementByXPath("//span[@class='post-card__content-price-offer']");
		System.out.println(price.getText());
		driver.findElementByXPath("//button[@class='combo-add-to-btn prdt-des-btn js--toggle-sbag nk-btn nk-btn-rnd atc-simple m-content__product-list__cart-btn  ']").click();
		driver.findElementByXPath("//div[@class='AddBagIcon']").click();
		WebElement grand = driver.findElementByXPath("//div[@class='first-col']");
		System.out.println(grand.getText());
		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		driver.findElementByXPath("//button[@class='btn full big']").click();
		WebElement print = driver.findElementByXPath("//div[@class='layout horizontal center message flex-1']");
		System.out.println(print.getText());
		driver.quit();
	
	
	
	}
	
	
}