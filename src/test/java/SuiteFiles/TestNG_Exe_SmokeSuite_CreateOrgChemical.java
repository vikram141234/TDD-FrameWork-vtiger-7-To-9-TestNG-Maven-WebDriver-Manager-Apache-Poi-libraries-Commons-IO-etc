package SuiteFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerGenericUtility.WebDriverUtility;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;
import vtigerObjectRepository.OrganizationsPage;

public class TestNG_Exe_SmokeSuite_CreateOrgChemical {

	@Test(groups = "SmokeSuite")
    public void createOrgSelectChemicalFrmDrpDwn() throws IOException
    {
	WebDriverUtility wUtil=new WebDriverUtility();
	JavaUtility jUtil=new JavaUtility();
	ExcelFileUtility eUtil=new ExcelFileUtility();
	PropertyFileUtility putil=new PropertyFileUtility();
	
	String BROWSER=putil.readDataFromPropertyFile("browser");
	String URL=putil.readDataFromPropertyFile("url");
	String USERNAME=putil.readDataFromPropertyFile("username");
	String PASSWORD=putil.readDataFromPropertyFile("password");
		
	String ORGNAME=eUtil.readDataFromExcel("Organization", 1, 2)+jUtil.getRandomNum();
	
	System.setProperty("webdriver.chrome.driver", "V:\\AdvanceSeleniumChaitraMamBatch2\\Chrome Drivers\\chromedriver.exe");
	ChromeOptions option=new ChromeOptions();
	option.addArguments("--remote-allow-origins=*");
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver(option);
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("Invalid Browser");
	}

	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	HomePage hp=new HomePage(driver);
	hp.clickOnOrgLnk();
	
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrgLookUpImg();
	
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrg(ORGNAME);
	
	WebDriverUtility wutil=new WebDriverUtility();
	WebElement ele=driver.findElement(By.xpath("//select[@name='industry']"));
	wutil.handleDropdown(ele, 4);

    String Header=driver.findElement(By.className("dvHeaderText")).getText();
    
    if(Header.contains(ORGNAME))
    {
    	System.out.println("Pass");
    }
    else
    {
    	System.out.println("Fail");
    }
    HomePage hpp=new HomePage(driver);
    hpp.logOutOfApp(driver);
    System.out.println("Logout successfulll");

}
}