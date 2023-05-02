package vtigerScenariosPractice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginCreateOrgSelectChemicalFrmIndDrpDwn {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties prop=new Properties();
		prop.load(fis);
		String URL=prop.getProperty("url");
		String BROWSER=prop.getProperty("browser1");
		String USERNAME=prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");
		Random r=new Random();
		int num=r.nextInt(1000);
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
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
		driver.findElement(By.name("accountname")).sendKeys("Gvc"+num);
		WebElement ele=driver.findElement(By.xpath("//select[@name='industry']"));
		Select s=new Select(ele);
	    s.selectByIndex(4);
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	    String Header=driver.findElement(By.className("dvHeaderText")).getText();
	    String Ind=driver.findElement(By.xpath("//td[@id='mouseArea_Industry']")).getText();
	    if(Header.contains("Gvc"))
	    {
	    	System.out.println("Gvc");
	    }
	    else if(Ind.contains("Chemicals"))
	    {
	    	System.out.println("Chemicals");
	    }
	    else
	    {
	    	System.out.println("Fail");
	    }
	    WebElement ele1=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele1).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
