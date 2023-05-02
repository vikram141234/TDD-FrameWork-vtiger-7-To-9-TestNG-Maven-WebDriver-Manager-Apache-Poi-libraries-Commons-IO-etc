package vtigerScenariosPractice;

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

public class CreateContactSelectOrgFromLookUpVerifyLogout {

	public static void main(String[] args) throws IOException {
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.Properties");
		Properties prop=new Properties();
		prop.load(fisp);
		String URL=prop.getProperty("url");
		String BROWSER=prop.getProperty("browser");
		String USERNAME=prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\vtigerExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Contacts");
		Row rw = sh.getRow(8);
		Cell ce = rw.getCell(0);
		String Contact = ce.getStringCellValue();
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(USERNAME,Keys.TAB,PASSWORD,Keys.ENTER);
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(Contact);
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
		String Header=driver.findElement(By.className("dvHeaderText")).getText();
		String Org=driver.findElement(By.className("dvtCellLabel")).getText();
		if(Header.contains(Contact))
		{
			System.out.println(Contact);
		}
		else if(Org.contains("Vicky522"))
		{
			System.out.println(Org);
		}
		else
		{
			System.out.println("---Fail---");		
		}
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
