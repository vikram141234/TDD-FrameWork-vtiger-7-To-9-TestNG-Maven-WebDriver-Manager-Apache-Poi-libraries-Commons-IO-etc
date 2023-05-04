package SuiteFiles;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerGenericUtility.WebDriverUtility;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;
import vtigerObjectRepository.OrganizationInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class TestNG_Exe_CreateOrgVerify {

	@Test(groups="SmokeSuite")
	public void createOrgVerify() throws IOException
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
	
	String ORGNAME=eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNum();
	
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
	hp.clickOnOrgLnk();
	
	//Step-4:Click on create Organization LookUp Image
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
	
	//Step-5:Create Organization with mandiatory fields
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrg(ORGNAME);
	
	//Step-6:Validation
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String OrgHeader=oip.getOrgHeader();
	if(OrgHeader.contains(ORGNAME))
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
//	driver.close();

	
}
}