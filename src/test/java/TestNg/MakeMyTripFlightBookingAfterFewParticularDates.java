package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripFlightBookingAfterFewParticularDates {

	WebDriver driver;

	@Test
	public void flight() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "V:\\Selenium Drivers2\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		Thread.sleep(2000);
		
		Actions act=new Actions(driver);            //This is because by defaultly after clicking from city page
		act.moveByOffset(10, 10).click().perform(); //is moving down
		
		//Navigate from and to elements
		WebElement src=driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
		WebElement dst=driver.findElement(By.xpath("//input[@data-cy='toCity']"));
		
		src.sendKeys("chennai");
		driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
	    Thread.sleep(2000);
		dst.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='chNavIcon appendBottom2 chSprite chFlights active']")).click();
		driver.findElement(By.xpath("//label[@for='departure']")).click();
//		driver.findElement(By.xpath("//div[@aria-label='Sun May 21 2023']")).click();
		
		  while(true) 
		  { 
			  try 
			  { 
				  Thread.sleep(1000);
				  driver.findElement(By.xpath("//div[@aria-label='Tue Aug 01 2023']")).click();
				  break;
			  } 
			  catch(Throwable t)
			  {
				  WebElement element=driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				  element.click();
		      }
		  }
//		  driver.close();
		 
	}

}
