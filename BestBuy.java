package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BestBuy {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.bestbuy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//img[@alt='United States']").click();
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@class='c-modal-grid col-xs-6']/button[1]"))).click();
		driver.findElementByXPath("//button[text()='Products']/div").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='Cell Phones']").click();
		driver.findElementByXPath("//div[text()='iPhone']").click();
		driver.findElementByLinkText("iPhone SE").click();
		driver.findElementByXPath("(//span[@class='image-width'])[4]").click();
		driver.findElementByLinkText("Continue").click();
		WebElement element = driver.findElementByXPath("//span[@class='variation-dropdown-tile ']");
		Select dropDown= new Select(element);
		dropDown.selectByIndex(1);
		driver.findElementByXPath("//button[@class='activated-pricing__button activated-pricing__button--selected']").click();
		
		
	}

}
