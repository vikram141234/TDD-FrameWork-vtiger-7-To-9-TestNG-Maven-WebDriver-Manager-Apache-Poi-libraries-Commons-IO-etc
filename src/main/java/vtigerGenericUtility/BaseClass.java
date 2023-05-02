package vtigerGenericUtility;

import java.io.IOException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;
/**
 * This Class consists of all Basic Configuration Annotations
 */
public class BaseClass {

	public JavaUtility jUtility=new JavaUtility();
	public WebDriverUtility wUtility=new WebDriverUtility();
	public ExcelFileUtility eUtility=new ExcelFileUtility();
	public PropertyFileUtility pUtility=new PropertyFileUtility();
	
	public WebDriver driver=null;
	public static WebDriver sDriver;
	
	 @BeforeSuite(alwaysRun = true)
		public void bsConfig()
		{
			System.out.println("---Database Connection Successfully---");
		}
//      @Parameters("BROWSER")       //To launch browser at Test Level We Can Also launch browser at Test Level        //Only AfterTest For Distributed Parallel Exe
//	  @BeforeTest
	  @BeforeClass//(groups={"SmokeSuite","RegressionSuite"})
		public void bcConfig(/*String BROWSER*/) throws IOException
		{  // have to comment Browser in down in args it will read from xml suite file
			String BROWSER = pUtility.readDataFromPropertyFile("browser");
			String URL = pUtility.readDataFromPropertyFile("url");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			if(BROWSER.equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver(options);
				System.out.println("Browser Launched Successfully");
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver(); 
				System.out.println("Browser Launched Successfully");
			}
			else 
			{
				System.out.println("Invalid Browser");
			}
			sDriver=driver;   //To Take ScreenShot
			wUtility.maximizeTheWindow(driver);
			wUtility.waitUntilPageLoad(driver);
			driver.get(URL);
		}
		
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})
		public void bmConfig() throws IOException
		{
		    String USERNAME = pUtility.readDataFromPropertyFile("username");
		    String PASSWORD = pUtility.readDataFromPropertyFile("password");
		    
			LoginPage lPage=new LoginPage(driver);
			lPage.loginToApp(USERNAME, PASSWORD);
			System.out.println("---Login successfully---");
		}

	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
		public void amConfig()
		{
		    HomePage hPage=new HomePage(driver);
			hPage.logOutOfApp(driver);
			System.out.println("Logout Successfully");
		}
	@AfterTest  //View Details at Before Class Annotation
//	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
		public void acConfig()
		{
			driver.quit();
			System.out.println("Browser Closed Successfully");
		}
	
	
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})
		public void asConfig()
		{
		System.out.println("---Database Closed Successful---");
		}
	
}
