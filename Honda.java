package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Honda {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.honda2wheelersindia.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
// Click on scooters and click dio
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//button[@data-dismiss='modal']"))).click();
		driver.findElementByXPath("//a[@id='link_Scooter']").click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@id='scooter']/div//div/div)[1]"))).click();
//Click on Specifications and mouseover on ENGINE
		driver.findElementByLinkText("Specifications").click();
		WebElement engine = driver.findElementByXPath("//a[text()='ENGINE']");
		Actions builder = new Actions(driver);
		builder.moveToElement(engine).build().perform();
//Get Displacement value
		String displacement = driver.findElementByXPath("//div[@class='engine part-2 axx']//li[3]/span[2]").getText().replaceAll("cc", "");
		float dioDis = Float.parseFloat(displacement);
		System.out.println(dioDis);		
//Go to Scooters and click Activa 125	
		driver.findElementByXPath("//a[@id='link_Scooter']").click();
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("(//div[@id='scooter']/div//div/div)[5]"))).click();
		driver.findElementByXPath("(//div[@id='scooter']/div//div/div)[5]").click();
//Click on Specifications and mouseover on ENGINE		
		driver.findElementByXPath("//a[text()='Specifications']").click();
		WebElement activeEng = driver.findElementByXPath("//ul[@class='specifications']//a[text()='ENGINE']");
		builder.moveToElement(activeEng).build().perform();
//Get Displacement value		
		String activaDis = driver.findElementByXPath("//div[@class='engine part-4 axx']//li[3]/span[2]").getText().replaceAll(" ", "").replaceAll("cc", "");
		int activa = Integer.parseInt(activaDis);
		System.out.println(activa);
//Compare Displacement of Dio and Activa 125 and print the Scooter name having better Displacement.		
		if (dioDis > activa) {
			System.out.println("Dio is the Better Displacement");
		} else {
			System.out.println("Activa125 is the Better Displacement");
		}
//Click FAQ from Menu 		
		driver.findElementByXPath("//a[text()='FAQ']").click();
//Click Activa 125 BS-VI under Browse By Product
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		driver.findElementByXPath("//h4[text()='Scooter']/following::a[text()='Activa 125 BS-VI']").click();
// Click  Vehicle Price 
		driver.findElementByXPath("(//ul[@class='nav nav-pills tabb-design  ']//a)[6]").click();
//Make sure Activa 125 BS-VI selected and click submit
		
		
		
	}

}
/*

11)
12) 
13) click the price link
14)  Go to the new Window and select the state as Tamil Nadu and  city as Chennai
15) Click Search
16) Print all the 3 models and their prices
17) Close all the Windows*/