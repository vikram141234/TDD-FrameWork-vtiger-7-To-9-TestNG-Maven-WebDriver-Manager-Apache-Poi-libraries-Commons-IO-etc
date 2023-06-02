package TestNg;

import java.lang.invoke.MethodHandles.Lookup.ClassOption;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripFlightBookingCurrentDateCalendarPopup {

	WebDriver driver;
	@Test
	public void selectCurrentDate() throws InterruptedException {
		Date d=new Date();
		String dArr=d.toString();
		System.out.println(dArr);
		String[] arr = dArr.split(" ");
		String day=arr[0];
		String month=arr[1];
		String date=arr[2];
		String year=arr[5];
		String travelDate = day+" "+month+" "+date+" "+year;
		System.out.println(travelDate);
		
		System.setProperty("webdriver.chrome.driver", "V:\\Selenium Drivers2\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver=new ChromeDriver(option);
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		
		Actions act=new Actions(driver);            //This is because by defaultly after clicking from city page
		act.moveByOffset(10, 10).click().perform(); //is moving down
		
		//Navigate from and to elements
		WebElement src=driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
		WebElement dst=driver.findElement(By.xpath("//input[@data-cy='toCity']"));
	
		src.sendKeys("chennai");
		driver.findElement(By.xpath("//p[.='Chennai, India']")).click();
		
		dst.sendKeys("mumbai");
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();

//		driver.findElement(By.xpath("//label[@for='departure']")).click();
	
		driver.findElement(By.xpath("//div[@aria-label='"+travelDate+"']")).click();

	}
}
