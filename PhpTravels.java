package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PhpTravels {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Click on the Tours Button
		driver.findElementByXPath("//a[@class='text-center tours ']").click();
		//Enter Destination as Big Bus Tour of Dubai 
		WebElement destination = driver.findElementByXPath("(//input[@class='select2-input'])[8]");
		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.click(destination,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		
		
		
		
		
		
		

	}

}
