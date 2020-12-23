package workout90Days;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Atlassian {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://id.atlassian.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//Enter email "hari.radhakrishnan@testleaf.com" and click continue
		driver.findElementByXPath("//input[@placeholder='Enter email']").sendKeys("hari.radhakrishnan@testleaf.com");
		driver.findElementByXPath("//button[@id='login-submit']").click();
//Enter password "India@123" and click sign in		
		driver.findElementByXPath("//input[@placeholder='Enter password']").sendKeys("India@123");
		driver.findElementByXPath("//button[@id='login-submit']").click();
//Select the project "rest-api"
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//div[@data-test-id='collab-graph-container-row']//a//span"))).click();
		//driver.findElementByXPath("//a[@class='sc-gPEVay KsSAI']").click();
//Click on Backlog in the left panel		
		wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//a[@draggable='false']/div"))).click();
		//driver.findElementByXPath("//a[@draggable='false']/div").click();
// Get the total number of issues and print the count alone (only number)		
		Thread.sleep(3000);
		String issues = driver.findElementByXPath("//div[@class='header-left']/div[3]").getText().replaceAll(",", "").replaceAll(" ", "").replaceAll("issues", "");
		System.out.println(issues);
//Click on Create with Issue type as "Story" and Summary as "Created by <your name>" 	
		driver.findElementByXPath("//button[@id='createGlobalItem']").click();
	driver.findElementByXPath("//div[@id='issuetype-single-select']").click();
	driver.findElementByXPath("//input[@id='summary']").sendKeys("Created by Elumalai");
	}

}
/*


2. 
3. 
4. 
5. 
6.
7. 
8. Attach a image from local directory and Click Create
9. Verify the newly created story by Search the Story by your Name and Confirm
10. Open the newly created story 
11. Modify the assignee as "Vivek"
12. Change the Priority as Low
13. Navigate to the Backlog
14. Click on Recently Updated
15. Validate the Assignee and Priority values for the newly created Story as expected
16. Click on the Story 
17. Click on Actions and Delete the Story
18. Confirm the Delete
19. Recently Updated section in Backlog should not have any items*/