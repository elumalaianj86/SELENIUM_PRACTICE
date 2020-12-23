package workout90Days;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CRMCloud {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://demo.1crmcloud.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Give username as admin and password as admin
		driver.findElementById("login_user").sendKeys("admin");
		driver.findElementById("login_pass").sendKeys("admin");
		//Choose theme as Claro Theme
		WebElement theme = driver.findElementById("login_theme");
		Select dropDown = new Select(theme);
		dropDown.selectByVisibleText("Claro Theme");
		driver.findElementById("login_button").click();
		//	Click on Sales and Marketting 
		driver.findElementById("grouptab-1").click();
		// Click Create contact	
		Thread.sleep(3000);
		driver.findElementByXPath("(//div[@class='option-cell input-label '])[1]").click();
		//	Select Title and type First name, Last Name, Email and Phone Numbers
		WebElement title = driver.findElementByXPath("//div[@class='form-value']//div[@id='DetailFormsalutation-input-label']");
		Actions builder = new Actions(driver);
		Thread.sleep(3000);
		builder.click(title).perform();
		driver.findElementByXPath("//div[text()='Mr.']").click();
		driver.findElementById("DetailFormfirst_name-input").sendKeys("Sivaraman");
		driver.findElementById("DetailFormlast_name-input").sendKeys("R");
		driver.findElementById("DetailFormemail1-input").sendKeys("sivaramanvd@gmail.com");
		driver.findElementById("DetailFormphone_work-input").sendKeys("9900234567");
		//Select Lead Source as "Public Relations"
		WebElement source= driver.findElementById("DetailFormlead_source-input-label");
		Thread.sleep(3000);
		builder.click(source).perform();
		driver.findElementByXPath("//div[text()='Public Relations']").click();
		// Select Business Roles as "Sales"
		WebElement business	= driver.findElementById("DetailFormbusiness_role-input-label");
		Thread.sleep(3000);
		builder.click(business).perform();
		driver.findElementByXPath("//div[text()='Sales']").click();
		//Fill the Primary Address, City, State, Country and Postal Code and click Save
		driver.findElementById("DetailFormprimary_address_street-input").sendKeys("periyar nagar");
		driver.findElementById("DetailFormprimary_address_city-input").sendKeys("chennai");
		driver.findElementById("DetailFormprimary_address_state-input").sendKeys("TamilNadu");
		driver.findElementById("DetailFormprimary_address_country-input").sendKeys("India");
		driver.findElementById("DetailFormprimary_address_postalcode-input").sendKeys("600042");
		driver.findElementById("DetailForm_save2-label").click();
		// Mouse over on Today's Activities and click Meetings
		Thread.sleep(3000);
		WebElement today= driver.findElementById("grouptab-0");
		builder.moveToElement(today).build().perform();	
		driver.findElementByXPath("//div[text()='Calendar']/following::div[text()='Meetings']").click();
		// Click Create
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[text()='Create'])[1]").click();
		// Type Subject as "Project Status" , Status as "Planned" 
		driver.findElementById("DetailFormname-input").sendKeys("Project Status");
		WebElement status = driver.findElementById("DetailFormstatus-input");
		Thread.sleep(3000);
		/*builder.click(status).build().perform();
	driver.findElementByXPath("//div[text()='Planned']").click();
		 */	// Start Date & Time as tomorrow 3 pm and Duration as 1hr
		driver.findElementByXPath("//div[@class='input-label datetime-label text-number']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='24']").click();
		WebElement time = driver.findElementByXPath("(//input[@class='input-text'])[4]");
		time.clear();
		time.sendKeys("15:00",Keys.ENTER);
		WebElement duration = driver.findElementById("DetailFormduration-time");
		duration.clear();
		duration.sendKeys("1h",Keys.TAB);
		// Click Add paricipants, add your created Contact name and click Save
		driver.findElementByXPath("(//span[@class='input-label'])[5]").click();
		driver.findElementByXPath("//div[text()='Sivaraman R']").click();
		driver.findElementById("DetailForm_save2-label").click();	
		// Go to Sales and Marketting-->Contacts
		WebElement sales=driver.findElementById("grouptab-1");
		builder.moveToElement(sales).build().perform();	
		Thread.sleep(3000);
		driver.findElementByXPath("//div[text()='Contacts']").click();
		// search the lead Name and click the name from the result
		 driver.findElementById("filter_text").sendKeys("Sivaraman");
		Thread.sleep(500);
		driver.findElementById("filter_text").sendKeys(Keys.ENTER);
		Thread.sleep(500);
		driver.findElementById("filter_text").click();
		driver.findElementByLinkText("Mr. Sivaraman R").click();
		// Check weather the Meeting is assigned to the contact under Activities Section.
		
		
		
		
	}

}
