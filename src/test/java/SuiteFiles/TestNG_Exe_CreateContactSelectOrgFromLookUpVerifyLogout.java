package SuiteFiles;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
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

public class TestNG_Exe_CreateContactSelectOrgFromLookUpVerifyLogout {
	

	    @Test
	    public void createConSelectOrgFrmLookupIcon() throws IOException
	    {
		WebDriverUtility wUtil=new WebDriverUtility();
		JavaUtility jUtil=new JavaUtility();
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
	
		String URL=pUtil.readDataFromPropertyFile("url");
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String LASTNAME =eUtil.readDataFromExcel("Contacts", 4, 2);
		String ORGNAME=eUtil.readDataFromExcel("Contacts", 4, 3)+jUtil.getRandomNum();
		
		System.setProperty("webdriver.chrome.driver", "V:\\AdvanceSeleniumChaitraMamBatch2\\Chrome Drivers\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver(option);
		}
		else if(BROWSER.equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser");
		}
		
		wUtil.maximizeTheWindow(driver);
		wUtil.waitUntilPageLoad(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String HeaderText=oip.getOrgHeader();
		if(HeaderText.contains(ORGNAME))
		{
			System.out.println("Org Created Successfully");
		}
		else
		{
			System.out.println("Org not Created Successfully");
		}
		
		hp.clickOnContactLnk();
		
		ContactsPage cp=new ContactsPage(driver);
		cp.ClickOnCreateContactLookUpImg();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		
//		CreateNewContactPage ccp=new CreateNewContactPage(driver);
//		ccp.createNewContact(driver, LASTNAME, ORGNAME);
//		String parent=driver.getWindowHandle();
//		wUtil.takeScreenShot(driver, "Contact-1");		

		//Validation
		ContactInfoPage cip=new ContactInfoPage(driver);
		String ContactHeader=cip.getContactHeader();
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println("--Pass--");
		}
		else
		{
			System.out.println("--Fail--");
		}
		//Logout
		hp.logOutOfApp(driver);
		System.out.println("--Signout Successfully--");
		
	}

}
