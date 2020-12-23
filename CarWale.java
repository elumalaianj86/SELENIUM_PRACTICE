package workout90Days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CarWale {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.carwale.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//li[@class='welcome-box__search-item js-welcome-box__list-item']").click();
		Thread.sleep(3000);
		driver.findElementById("usedCarsList").sendKeys("chennai");
		Thread.sleep(3000);
		driver.findElementById("usedCarsList").sendKeys(Keys.TAB);
		driver.findElementById("minInput").sendKeys("8",Keys.TAB);
		driver.findElementById("maxInput").sendKeys("12",Keys.TAB);
		driver.findElementById("btnFindCar").click();
		driver.findElementByXPath("//span[text()='Cars with Photos']").click();
		//select hyundai
		Thread.sleep(3000);
		WebElement element = driver.findElementByXPath("//span[text()=' Hyundai ']");
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.PAGE_DOWN).build().perform();
		builder.click(element).build().perform();
		//select fueltype
		Thread.sleep(5000);
		WebElement fuelPath = driver.findElementByXPath("(//h3[@class='sub-values'])[6]");
		builder.click(fuelPath).build().perform();
		//select petrol
		driver.findElementByXPath("//span[text()='Petrol']").click();
		//select BestMatch
		WebElement options = driver.findElementById("sort");
		Select dropDown = new Select(options);
		dropDown.selectByVisibleText("Price: Low to High");
		//Validate the Cars are listed with KMs Low to High
		Thread.sleep(3000);
		List<WebElement> kmList = driver.findElementsByXPath("//span[@class='slkms vehicle-data__item']");
		int size = kmList.size();
		List<Integer> kmValue = new ArrayList<Integer>();
		for (int i = 1; i <= size; i++) {
			String text = driver.findElementByXPath("(//span[@class='slkms vehicle-data__item'])["+i+"]").getText().replaceAll(",", "").replaceAll("km", "").replaceAll(" ", "");
			kmValue.add(Integer.parseInt(text));
			System.out.println(text);
		}

		int original = kmValue.get(0);
		System.out.println("The first car in low Km in application" + original);
		Collections.sort(kmValue);

		int sorted = kmValue.get(0);
		System.out.println("Sorted lowest KM vlaue"+ sorted);

		if(original==sorted) {
			System.out.println("The KM value is printed form low to high");
		}
		else
		{
			System.out.println("The Km value is not printed from low to high");
		}
		//select the wish
		WebElement heartWish = driver.findElementByXPath("(//a[@class='slideShow car-item__image-link'])[2]/following-sibling::span[2]");
		builder.click(heartWish).perform();
		//click the whisList and click on more details
		driver.findElementByXPath("//li[@class='action-box shortlistBtn']").click();
		driver.findElementByLinkText("More details »").click();
		//print all values of overview
		Set<String> handles = driver.getWindowHandles();
		List<String> window = new ArrayList<String>(handles);
		String handle1 = window.get(1);
		driver.switchTo().window(handle1);
		List<WebElement> row = driver.findElementsByXPath("//div[@id='overview']//li");
		int rowsize = row.size();
		List<WebElement> cell = driver.findElementsByXPath("//div[@id='overview']//li[1]/div");
		int cellsize = cell.size();
		for (int i = 1; i <= rowsize; i++) {
			for (int j = 1; j <=cellsize; j++) {
				String details = driver.findElementByXPath("//div[@id='overview']//li["+i+"]/div["+j+"]").getText();
				System.out.println(details);
			}
			System.out.println(" ");	 
		}
	driver.quit();	

	
	
	
	}
}


