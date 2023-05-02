package SuiteFiles;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerGenericUtility.WebDriverUtility;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;
import vtigerObjectRepository.OrganizationInfoPage;
import vtigerObjectRepository.OrganizationsPage;
 
public class TestNG_Exe_CreateNewContactVerify {

	@Test
    public void createNewContact() throws EncryptedDocumentException, IOException
    {
		//Create Object of all Utilities
				JavaUtility jUtil=new JavaUtility();
				PropertyFileUtility pUtil=new PropertyFileUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				WebDriverUtility wUtil=new WebDriverUtility();
				
				//Read all the required data
				String URL=pUtil.readDataFromPropertyFile("url");
				String BROWSER = pUtil.readDataFromPropertyFile("browser");
				String USERNAME = pUtil.readDataFromPropertyFile("username");
				String PASSWORD = pUtil.readDataFromPropertyFile("password");
				
				String CONTACTNAME=eUtil.readDataFromExcel("Contacts", 1, 2)+jUtil.getRandomNum();
				
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--remote-allow-origins=*");
				
				System.setProperty("webdriver.chrome.driver", "V:\\Selenium Drivers\\chromedriver.exe");
				
				WebDriver driver=null;
				//Step-1:Launch Browser
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver(option);
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
				wUtil.waitUntilPageLoad(driver);
				driver.get(URL);
				
				//Step-2:Login to Application
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(USERNAME,PASSWORD);
				
				//Step-3:Navigate to Organization Link
				HomePage hp=new HomePage(driver);
				hp.clickOnContactLnk();
				
				//Step-4:Click on create Organization LookUp Image
				ContactsPage op=new ContactsPage(driver);
				op.ClickOnCreateContactLookUpImg();
				
				//Step-5:Create Organization with mandiatory fields
				CreateNewContactPage cnop=new CreateNewContactPage(driver);
				cnop.createNewContact(CONTACTNAME);
				
				//Step-6:Validation
				ContactInfoPage oip=new ContactInfoPage(driver);
				String ContactHeader=oip.getContactHeader();
				if(ContactHeader.contains(CONTACTNAME))
				{
					System.out.println("---pass---");
				}
				else
				{
					System.out.println("---fail---");
				}
				//Step-7:Logout
				hp.logOutOfApp(driver);
				System.out.println("--SignOut Successfull--");
//				driver.close();
}
}
