package SuiteFiles;


import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;

public class TestNG_Exe_CreateContactWith2DrpDwns {

	    @Test
	    public void createConWith2DrpDwn() throws IOException
	    {
		PropertyFileUtility pUtil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		
		String URL=pUtil.readDataFromPropertyFile("url");
		String BROWSER=pUtil.readDataFromPropertyFile("browser");
		String USERNAME=pUtil.readDataFromPropertyFile("username");
		String PASSWORD=pUtil.readDataFromPropertyFile("password");
		
		String ORGName=eutil.readDataFromExcel("Contacts", 4, 3);
		
		System.setProperty("webdriver.chrome.driver", "V:\\Selenium Drivers\\chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))     //Run Time Polymorphism
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
		
		
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGName);
		WebElement ele=driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(ele);
		s.selectByValue("Energy");
		WebElement ele1=driver.findElement(By.name("accounttype"));
		Select s1=new Select(ele1);
		s1.selectByIndex(3);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String Header=driver.findElement(By.className("dvHeaderText")).getText();
		String Ind=driver.findElement(By.className("dvtCellLabel")).getText();
		String Type=driver.findElement(By.className("dvtCellLabel")).getText();
		if(Header.contains(ORGName))
		{
			System.out.println(Header);
		}
		else if(Ind.contains("Energy"))
		{
			System.out.println(Ind);
		}
		else if(Type.contains("Customer"))
		{
			System.out.println(Type);
		}
		else
		{
			System.out.println("Fail");
		}
		WebElement ele2=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele2).perform();
//		driver.findElement(By.linkText("Sign Out")).click();


	}

}
