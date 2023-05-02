package VickyvtigerDataProviderGenericUtilityScenariosPracticeTestNG;

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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.HomePage;

public class CreateOrgWContactSelectOrgFromLookupVerifyLogout extends BaseClass{

	@Test(groups="RegressionSuite")
	public void createContactSelectOrgFromLookupVerifyLogout() throws IOException
	  {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		String CONTACT =eUtil.readDataFromExcel("Contacts", 1, 1);
		
		HomePage hPage=new HomePage(driver);
		hPage.clickOnContactLnk();
		
		ContactsPage cPage=new ContactsPage(driver);
		cPage.ClickOnCreateContactLookUpImg();
		
		CreateNewContactPage cnPage=new CreateNewContactPage(driver);
		cnPage.createNewContact(CONTACT);
	
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath("//img[contains(@onclick,'re')]")).click();
		Set<String> child=driver.getWindowHandles();
		for(String childid:child)
		{
			driver.switchTo().window(childid);
		}
		driver.findElement(By.linkText("Vicky522")).click();
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		ContactInfoPage ciPage=new ContactInfoPage(driver);
		String header=ciPage.getContactHeader();
		
		if(header.contains(CONTACT))
		{
			System.out.println(CONTACT);
		}
		else
		{
			System.out.println("---Fail---");		
		}
		
		hPage.logOutOfApp(driver);

	}

}
