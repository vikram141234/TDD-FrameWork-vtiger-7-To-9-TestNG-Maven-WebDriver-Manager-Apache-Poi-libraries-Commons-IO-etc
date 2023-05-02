package VickyvtigerDataProviderGenericUtilityScenariosPracticeTestNG;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtility.ConstantsUtility;
import vtigerGenericUtility.PropertyFileUtility;

public class CreateOrgWithIndEnergyAndTypeCustmrDropDowns {

	@Test(groups = "SmokeSuite")
	public void createOrgWithIndEnergyAndTypeCustmrDropDowns() throws IOException
	{
		PropertyFileUtility pfu=new PropertyFileUtility();
		String URL=pfu.readDataFromPropertyFile("url");
		String BROWSER=pfu.readDataFromPropertyFile("browser");
		String USERNAME=pfu.readDataFromPropertyFile("username");
		String PASSWORD=pfu.readDataFromPropertyFile("password");
		FileInputStream fise=new FileInputStream(ConstantsUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Contacts");
		Row rw = sh.getRow(1);
		Cell ce = rw.getCell(1);
		String ORG = ce.getStringCellValue();
		Random r=new Random();
		int num=r.nextInt(1000);
		
		System.setProperty("chromedriver.chrome.driver", "V:\\Selenium Drivers\\chromedriver.exe");
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))     //Run Time Polymorphism
		{
			WebDriverManager.chromedriver().setup();
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
//		WebDriver driver=new ChromeDriver(option);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORG+num);
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
		if(Header.contains(ORG))
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
		driver.findElement(By.linkText("Sign Out")).click();

	}
	
//	    @Test(groups = "RegressionSuite")
//	     public void Demo() 
//	     {
//		     System.out.println("Regression suite Demo");
//	     }

}
