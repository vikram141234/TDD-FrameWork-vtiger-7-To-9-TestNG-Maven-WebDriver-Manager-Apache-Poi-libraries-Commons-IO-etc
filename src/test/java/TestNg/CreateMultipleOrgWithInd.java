package TestNg;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtigerGenericUtility.BaseClass;
import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerGenericUtility.WebDriverUtility;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateMultipleOrgWithInd extends BaseClass{
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgTest(String ORG,String INDUSTRY) throws IOException
	{
		JavaUtility jUtility=new JavaUtility();
		String ORGNAME=ORG+jUtility.getRandomNum();
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImg();
		
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrg(ORGNAME, INDUSTRY);

	    String Header=driver.findElement(By.className("dvHeaderText")).getText();
        
	    Assert.assertTrue(Header.contains(ORGNAME));
	}
	
	
	@DataProvider /*(name="multipleData")*/ //OPTIONAL NAME giving beside @Test (dataprovider="multipleData")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtility.readMultipleDataFromExcel("DataProviderOrgInd");
	}
	
}
