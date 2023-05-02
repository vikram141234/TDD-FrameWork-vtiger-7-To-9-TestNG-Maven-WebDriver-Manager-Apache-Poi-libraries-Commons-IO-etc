package VickyVtigerGenericUtilitiesPratice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileSystemUtils;
import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains all generic method related to web driver
 * @author vikra
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeTheWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeTheWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method will wait until the webpage loaded
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method will wait until the element is clicked
	 * @param driver
	 * @param element
	 */
	public void waitUntilElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will wait until the element is visible
	 * @param driver
	 * @param element
	 */
	public void waitUntilElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will handle dropdown by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) 
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * This method will handle dropdown by value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
//	/**
//	 * This method will handle 2 dropdowns by its values
//	 * @param element
//	 * @param value
//	 */
//	public void handleDropDown(WebElement element,String value,int value2)
//	{
//		Select s=new Select(element);
//		s.selectByValue(value);
//		s.selectByIndex(value2);
//	}
	
	/**
	 * This method will handle dropdown by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method will handle mouse hover actions
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform right click action in web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click operation on a particular element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click operation on a web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click operation on a particular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop operation from SRC ele to DST ele
	 * @param driver
	 * @param srcEle
	 * @param dstEle
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcEle,WebElement dstEle)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcEle, dstEle).perform();
	}
	
	/**
	 * This method will press on enter key
	 * @throws AWTException
	 */
	public void pressEnterKey() throws AWTException
	{
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame by name or id
	 * @param driver
	 * @param nameOrId
	 */
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame by web element
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to immediate parent
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This Method will accept alerts
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * Tjis method will capture the alert text
	 * @param driver
	 */
	public void getAlertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will capture Screenshot
	 * @param driver
	 * @param methodname
	 * @return
	 * @throws IOException
	 */
	public String takeScreenshot(WebDriver driver,String methodname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver; 
		File sshotType=ts.getScreenshotAs(OutputType.FILE);
		File storingFolder=new File(".\\7to9.maven\\Screenshots"+methodname+".png" );
		FileUtils.copyFile(sshotType, storingFolder);
		return storingFolder.getAbsolutePath();
	
	}
	public void switchToWindow(WebDriver driver,String parentWinTitle)
	{
		Set<String>allWinIds=driver.getWindowHandles();
		for(String windows:allWinIds)
		{
			String currentTitle=driver.switchTo().window(windows).getTitle();
			if(currentTitle.contains(parentWinTitle))
			{
				break;
			}
		}
	}
	
	/**
	 * This method scroll randomly downwards
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		int y=element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")");
	}
	
	/**
	 * This method will return the calendar
	 * @return
	 */
	public String calendar()
	{
		Calendar cal=Calendar.getInstance();
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
		String date=sdf.format(d);
		return date;
	}
	
	/**
	 * This method will return the customized date with respect to day
	 * @param addDay
	 * @return
	 */
	public String calendarDay(int addDay)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, addDay);
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
		String date=sdf.format(d);
		return date;
	}
	
	/**
	 * This method will return calendar date based on year
	 * @param addYear
	 * @return
	 */
	public String calendarYear(int addYear)
	{
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.YEAR, addYear);
		Date d=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
		String date=sdf.format(d);
		return date;
	}
	
	/**
	 * This method will perform logout action
	 * @param driver
	 * @param element
	 */
	public void logOutAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}

	
	
	
	
	
	
			
	
	
	
	
}
