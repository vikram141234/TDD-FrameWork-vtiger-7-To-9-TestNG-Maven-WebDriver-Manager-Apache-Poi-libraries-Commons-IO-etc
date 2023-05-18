package TestNg;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTodaysDateFlightBooking  {
	WebDriver driver;

	@Test
	public void flight() {
		
		System.setProperty("webdriver.chrome.driver", "V:\\Selenium Drivers2\\chromedriver.exe");
		WebDriverManager.firefoxdriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//label[@for='fromCity']")).click();
		driver.findElement(By.xpath("//div[.='BLR']")).click();
		driver.findElement(By.xpath("//label[@for='toCity']")).click();
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Tue May 09 2023']")).click();
		driver.findElement(By.xpath("//p[@data-cy='returnDefaultText']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Fri May 19 2023']")).click();
		
	}
}
