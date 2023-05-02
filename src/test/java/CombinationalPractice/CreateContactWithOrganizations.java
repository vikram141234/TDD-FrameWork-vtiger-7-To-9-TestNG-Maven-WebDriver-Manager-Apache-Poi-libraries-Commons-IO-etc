package CombinationalPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtility.BaseClass;
import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerGenericUtility.WebDriverUtility;
import vtigerObjectRepository.LoginPage;

public class CreateContactWithOrganizations extends BaseClass{

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		String URL = pUtil.readDataFromPropertyFile("url");
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcel("Contacts", 4, 3) + jUtil.getRandomNum();

		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver(options);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else 
		{
			System.out.println("Invalid Browser");
		}
		
		wUtil.maximizeTheWindow(driver);
		driver.get(URL);
		wUtil.waitUntilPageLoad(driver);

		// Step 2: Login to App
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Step 3: Navigate to Organizations LInk
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4: click on Create Organization Look Up Image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		// Step 5: Create Organization with Mnadatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		// Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 7: Validate
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (OrgHeader.contains(ORGNAME)) {
			System.out.println(OrgHeader + " --> Organization created successfully");
		} else {
			System.out.println("Organization creation failed");
		}

		/* Create Contact Using the same Organization */
		driver.findElement(By.linkText("Contacts")).click();

		// Step 9: Navigate create contact look up Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 10: Create Contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 11: Click on Organization look up Image
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		// Step 12: switch the control to child page
		wUtil.switchToWindow(driver, "Accounts");

		// Step 13: search for required Org
		driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
		driver.findElement(By.name("search")).click();

		// Step 14: click on Org
		// driver.findElement(By.linkText(ORGNAME)).click();

		// Dynamic xpath - ORGNAME is a dynamic Data
		// a[.='wipro123']
		// a[.='infy']
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();

		// Step 15: switch the control back to parent
		wUtil.switchToWindow(driver, "Contacts");
		wUtil.takeScreenShot(driver, "Contact");

		// Step 16: save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 17: Validate
		String ContactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (ContactHeader.contains(LASTNAME)) {
			System.out.println(ContactHeader + " -- PASS --");
		} else {
			System.out.println("-- FAIL --");
		}
		
		//Step 18 logout
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, ele);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Signout successfull");


	}

}
