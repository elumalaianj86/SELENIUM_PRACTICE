package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.makemytrip.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Click Hotels		
		driver.findElementByXPath("//li[@data-cy='menu_Hotels']").click();
//Enter city as Goa, and choose Goa, India		
		Thread.sleep(3000);
		driver.findElementByXPath("//span[@data-cy='hotelCityLabel']").click();
		driver.findElementByXPath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']").sendKeys("Goa",Keys.TAB);
// Enter Check in date as Next month 15th (May 15) and Check out as start date+5		
		driver.findElementByXPath("(//div[text()='15'])[2]").click();
		driver.findElementByXPath("(//div[text()='19'])[2]").click();
// Click on ROOMS & GUESTS and click 2 Adults and one Children(age 12). Click Apply Button.		
		driver.findElementByXPath("//p[@data-cy='roomGuestCount']").click();		
		driver.findElementByXPath("//ul[@data-cy='adultCount']/li[@data-cy='adults-2']").click();
		driver.findElementByXPath("//li[@data-cy='children-1']").click();
		WebElement age = driver.findElementByXPath("//select[@data-cy='childAge-0']");
		Select dropDown = new Select(age);
		dropDown.selectByVisibleText("12");
		driver.findElementByXPath("//button[@data-cy='submitGuest']").click();
// Click Search button
		driver.findElementByXPath("//button[@data-cy='submit']").click();
// Select locality as Baga
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[@class='checkmarkOuter']/label[@class='makeFlex column'])[4]").click();
// Select 5 start in Star Category under Select Filters
		Thread.sleep(3000);
		driver.findElementByXPath("//span[@class='checkmarkOuter']/label[text()='5 Star']").click();
// Click on the first resulting hotel and go to the new window
		WebElement hotel= driver.findElementByXPath("//p[@id='hlistpg_hotel_name']");
		hotel.click();
// Print the Hotel Name
		String hotelName = hotel.getText();
		System.out.println(hotelName);
// Click on BOOK THIS NOW
		Thread.sleep(3000);
		driver.findElementByXPath("//span[@id='detpg_book_combo_btn']").click();
//Print the Total Payable amount		
		String total = driver.findElementByXPath("//span[@id='revpg_total_payable_amt']").getText();
		System.out.println(total);
		/*	
			
			
			4)
			5)
			6)
			7)
			8)
			9)
			10) 
			11)
			12) 
			13) Close the browser*/

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
