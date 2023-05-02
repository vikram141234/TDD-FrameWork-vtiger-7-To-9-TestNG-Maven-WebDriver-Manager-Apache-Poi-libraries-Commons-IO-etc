package vtigerScenariosPractice;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgSaveAndVerifyTest {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://localhost:8888/");
		Random ran=new Random();
		int num=ran.nextInt(1000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin",Keys.TAB,"admin",Keys.ENTER);
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys("admin"+num);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String header=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		String orgname=driver.findElement(By.xpath("//a[.='admin95']")).getText();
		if(header.contains(orgname))
			System.out.println("---pass---");
		else
			System.out.println("---fail---");
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
